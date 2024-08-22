package app.com.eiduca.module.core.integration.concrete

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.concrete.IdentityCardCreate
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.service.concrect.IdentityCardService
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
class IdentityCardControllerIT {

    @Autowired lateinit var testRestTemplate: TestRestTemplate
    @Autowired lateinit var identityCardService: IdentityCardService
    @Autowired lateinit var personService: PersonService

    @Value("\${apiPrefix}")
    lateinit var apiPrefix: String
    val endpoint = "identity-cards"

    @Test
    @DisplayName("List pageable of identity cards when successful")
    fun findAll_WhenSuccessful() {
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint",HttpMethod.GET,null,
            ParameterizedTypeReference.forType<PageableResponse<IdentityCard>>(PageableResponse::class.java)
        )
        assertEquals(exchange.statusCode, ReturnStatus.OK)
    }

    @Test
    @DisplayName("Find identity card by id when successful")
    fun findById_WhenSuccessful() {
        var identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        identityCard.person  = personService.saveOrUpdate(identityCard.person)
        identityCard = identityCardService.saveOrUpdate(identityCard)
        val exchange = testRestTemplate.getForEntity("$apiPrefix/$endpoint/{id}",IdentityCard::class.java, identityCard.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.OK)
            exchange.body?.let { assertEquals(it.id, identityCard.id) }
        }
    }

    @Test
    @DisplayName("Create identity card when successful")
    fun save_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        identityCard.person  = personService.saveOrUpdate(identityCard.person)
        val exchange = testRestTemplate.postForEntity("$apiPrefix/$endpoint", identityCard.toIdentityCardRequest(), IdentityCard::class.java)
        assertIdentityCard(exchange, identityCard, ReturnStatus.CREATED)
    }

    @Test
    @DisplayName("Update identity card when successful")
    fun update_WhenSuccessful() {
        val identityCard = createIdentityCard(IdentityCardCreate.IDENTITY_CARD_UPDATE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.PUT, HttpEntity(identityCard.toIdentityCardRequest()), IdentityCard::class.java, identityCard.id)
        assertIdentityCard(exchange, identityCard, ReturnStatus.UPDATED)
    }

    @Test
    @DisplayName("Delete identity card by id when successful")
    fun deleteById_WhenSuccessful() {
        val identityCard = createIdentityCard(IdentityCardCreate.IDENTITY_CARD_UPDATE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.DELETE, null, Void::class.java, identityCard.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.DELETED)
        }
    }

    private fun assertIdentityCard(exchange: ResponseEntity<IdentityCard>, identityCard: IdentityCard, returnStatus: HttpStatus){
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, returnStatus)
            exchange.body?.let {
                assertNotNull(it.id)
                assertEquals(it.person, identityCard.person)
            }
        }
    }

    private fun createIdentityCard(identityCard: IdentityCard): IdentityCard{
        identityCard.person  = personService.saveOrUpdate(identityCard.person)
        return identityCardService.saveOrUpdate(identityCard)
    }

}