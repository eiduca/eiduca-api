package app.com.eiduca.module.core.integration.concrete

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.service.concrect.AddressService
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
class AddressControllerIT {

    @Autowired lateinit var testRestTemplate: TestRestTemplate
    @Autowired lateinit var addressService: AddressService
    @Value("\${apiPrefix}")
    lateinit var apiPrefix: String
    val endpoint = "addresses"

    @Test
    @DisplayName("List pageable of addresses when successful")
    fun findAll_WhenSuccessful() {
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint",HttpMethod.GET,null,
            ParameterizedTypeReference.forType<PageableResponse<Address>>(PageableResponse::class.java)
        )
        assertEquals(exchange.statusCode, ReturnStatus.OK)
    }

    @Test
    @DisplayName("Find address by id when successful")
    fun findById_WhenSuccessful() {
        val address = addressService.save(AddressCreate.ADDRESS_SAVE)
        val exchange = testRestTemplate.getForEntity("$apiPrefix/$endpoint/{id}",Address::class.java, address.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.OK)
            exchange.body?.let { assertEquals(it.id, address.id) }
        }
    }

    @Test
    @DisplayName("Create address when successful")
    fun save_WhenSuccessful() {
        val address = AddressCreate.ADDRESS_SAVE
        val exchange = testRestTemplate.postForEntity("$apiPrefix/$endpoint", address.toAddressRequest(), Address::class.java)
        assertAddress(exchange, address, ReturnStatus.CREATED)
    }

    @Test
    @DisplayName("Update address when successful")
    fun update_WhenSuccessful() {
        val address = addressService.save(AddressCreate.ADDRESS_SAVE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.PUT, HttpEntity(address.toAddressRequest()), Address::class.java, address.id)
        assertAddress(exchange, address, ReturnStatus.UPDATED)
    }

    @Test
    @DisplayName("Delete address by id when successful")
    fun deleteById_WhenSuccessful() {
        val address = addressService.save(AddressCreate.ADDRESS_UPDATE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.DELETE, null, Void::class.java, address.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.DELETED)
        }
    }

    private fun assertAddress(exchange: ResponseEntity<Address>, address: Address, returnStatus: HttpStatus){
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, returnStatus)
            exchange.body?.let {
                assertNotNull(it.id)
                assertEquals(it, address)
            }
        }
    }

}