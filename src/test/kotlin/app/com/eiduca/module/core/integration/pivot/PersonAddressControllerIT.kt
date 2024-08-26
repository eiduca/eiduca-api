package app.com.eiduca.module.core.integration.pivot

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.create.pivot.PersonAddressCreate
import app.com.eiduca.module.core.model.pivot.PersonAddress
import app.com.eiduca.module.core.service.concrect.AddressService
import app.com.eiduca.module.core.service.concrect.PersonService
import app.com.eiduca.module.core.service.pivot.PersonAddressService
import app.com.eiduca.module.core.wrapper.PageableResponse
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonAddressControllerIT {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate
    @Autowired
    lateinit var personAddressService: PersonAddressService
    @Autowired
    lateinit var addressService: AddressService
    @Autowired
    lateinit var personService: PersonService
    @Value("\${apiPrefix}")
    lateinit var apiPrefix: String
    val endpoint = "person-address"

    @Test
    @DisplayName("List pageable of address of person when successful")
    fun findAll_WhenSuccessful() {
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint", HttpMethod.GET,null,
            ParameterizedTypeReference.forType<PageableResponse<PersonAddress>>(PageableResponse::class.java)
        )
        assertEquals(exchange.statusCode, ReturnStatus.OK)
    }

    @Test
    @DisplayName("Find address of person by id when successful")
    fun findById_WhenSuccessful() {
        assertDoesNotThrow {
            val personAddress = createPersonAddress(PersonAddressCreate.PERSON_ADDRESS_SAVE)
            val exchange = testRestTemplate.getForEntity("$apiPrefix/$endpoint/{id}",PersonAddress::class.java, personAddress.id)
            assertEquals(exchange.statusCode, ReturnStatus.OK)
            exchange.body?.let { assertEquals(it.id, personAddress.id) }
        }
    }

    @Test
    @DisplayName("Create address of person when successful")
    fun save_WhenSuccessful() {
        val personAddress = createPersonAddress(PersonAddressCreate.PERSON_ADDRESS_SAVE)
        val exchange = testRestTemplate.postForEntity("$apiPrefix/$endpoint", personAddress.toPersonAddressRequest(), PersonAddress::class.java)
        assertPersonAddress(exchange, personAddress, ReturnStatus.CREATED)
    }

    @Test
    @DisplayName("Update address of person when successful")
    fun update_WhenSuccessful() {
        val personAddress = createPersonAddress(PersonAddressCreate.PERSON_ADDRESS_UPDATE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.PUT, HttpEntity(personAddress.toPersonAddressRequest()), PersonAddress::class.java, personAddress.id)
        assertPersonAddress(exchange, personAddress, ReturnStatus.UPDATED)
    }

    @Test
    @DisplayName("Delete address of person by id when successful")
    fun deleteById_WhenSuccessful() {
        val personAddress = createPersonAddress(PersonAddressCreate.PERSON_ADDRESS_UPDATE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.DELETE, null, Void::class.java, personAddress.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.DELETED)
        }
    }

    private fun assertPersonAddress(exchange: ResponseEntity<PersonAddress>, personAddress: PersonAddress, returnStatus: HttpStatus){
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, returnStatus)
            exchange.body?.let {
                assertNotNull(it.id)
                assertEquals(it, personAddress)
            }
        }
    }

    private fun createPersonAddress(personAddress: PersonAddress): PersonAddress{
        personAddress.person = personService.saveOrUpdate(personAddress.person)
        personAddress.address = addressService.save(personAddress.address)
        return personAddressService.save(personAddress)
    }

}