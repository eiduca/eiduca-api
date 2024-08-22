package app.com.eiduca.module.core.integration.concrete

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.concrete.PersonCreate
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.service.concrect.PersonService
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
class PersonControllerIT {

    @Autowired lateinit var testRestTemplate: TestRestTemplate
    @Autowired lateinit var personService: PersonService

    @Value("\${apiPrefix}")
    lateinit var apiPrefix: String
    val endpoint = "persons"

    @Test
    @DisplayName("List pageable of persons when successful")
    fun findAll_WhenSuccessful() {
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint",HttpMethod.GET,null,
            ParameterizedTypeReference.forType<PageableResponse<Person>>(PageableResponse::class.java)
        )
        assertEquals(exchange.statusCode, ReturnStatus.OK)
    }

    @Test
    @DisplayName("Find person by id when successful")
    fun findById_WhenSuccessful() {
        val person = personService.saveOrUpdate(PersonCreate.PERSON_SAVE)
        val exchange = testRestTemplate.getForEntity("$apiPrefix/$endpoint/{id}",Person::class.java, person.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.OK)
            exchange.body?.let { assertEquals(it.id, person.id) }
        }
    }

    @Test
    @DisplayName("Create person when successful")
    fun save_WhenSuccessful() {
        val person = PersonCreate.PERSON_NOT_EXIST
        val exchange = testRestTemplate.postForEntity("$apiPrefix/$endpoint", person.toPersonRequestPost(), Person::class.java)
        assertPerson(exchange, person, ReturnStatus.CREATED)
    }

    @Test
    @DisplayName("Update person when successful")
    fun update_WhenSuccessful() {
        val person = personService.saveOrUpdate(PersonCreate.PERSON_SAVE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint",HttpMethod.PUT, HttpEntity(person.toPersonRequestPut()), Person::class.java)
        assertPerson(exchange, person, ReturnStatus.UPDATED)
    }

    @Test
    @DisplayName("Delete person by id when successful")
    fun deleteById_WhenSuccessful() {
        val person = personService.saveOrUpdate(PersonCreate.PERSON_UPDATE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.DELETE, null, Void::class.java, person.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.DELETED)
        }
    }

    private fun assertPerson(exchange: ResponseEntity<Person>, person: Person, returnStatus: HttpStatus){
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, returnStatus)
            exchange.body?.let {
                assertNotNull(it.id)
                assertEquals(it.identityCardNumber, person.identityCardNumber)
            }
        }
    }

}