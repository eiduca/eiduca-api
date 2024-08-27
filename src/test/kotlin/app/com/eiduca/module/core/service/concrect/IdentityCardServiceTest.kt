package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.create.concrete.IdentityCardCreate
import app.com.eiduca.module.core.repository.concrect.IdentityCardRepository
import app.com.eiduca.module.core.repository.concrect.PersonRepository
import app.com.eiduca.module.core.seed.IdentityCardSeed
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@ExtendWith(SpringExtension::class)
@DisplayName("Test of identity card service")
class IdentityCardServiceTest {

    @InjectMocks
    lateinit var identityCardService: IdentityCardService

    @Mock
    lateinit var identityCardRepository: IdentityCardRepository

    @Mock
    lateinit var personRepository: PersonRepository

    @BeforeEach
    fun setUp() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        val identityCards = PageImpl(IdentityCardSeed.entries.map { it.identityCard })
        BDDMockito.`when`(identityCardRepository.findAll(Pageable.ofSize(15))).thenReturn(identityCards)
        BDDMockito.`when`(identityCardRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(identityCard))
        BDDMockito.`when`(identityCardRepository.findByPerson(identityCard.person)).thenReturn(Optional.of(identityCard))
        BDDMockito.`when`(identityCardRepository.save(identityCard)).thenReturn(identityCard)
        BDDMockito.doNothing().`when`(identityCardRepository).deleteById(ArgumentMatchers.anyString())

        BDDMockito.`when`(personRepository.save(identityCard.person)).thenReturn(identityCard.person)
    }

    @Test
    @DisplayName("List pageable of identity cards when successful")
    fun findAll_WhenSuccessful() {
        val response = identityCardService.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find identity card by id when successful")
    fun findById_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        assertDoesNotThrow {
            val response = identityCardService.findById(identityCard.id)
            assertEquals(response.id, identityCard.id)
        }
    }

    @Test
    @DisplayName("Find identity card by person when successful")
    fun findByPerson_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        assertDoesNotThrow {
            val response = identityCardService.findByPerson(identityCard.person)
            assertEquals(response, identityCard)
        }
    }

    @Test
    @DisplayName("Create identity card when successful")
    fun save_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        assertDoesNotThrow {
            val response = identityCardService.save(identityCard)
            assertNotNull(response.id)
            assertEquals(response, identityCard)
        }
    }

    @Test
    @DisplayName("Create or update identity card when successful")
    fun saveOrUpdate_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        assertDoesNotThrow {
            val response = identityCardService.saveOrUpdate(identityCard)
            assertNotNull(response.id)
            assertEquals(response, identityCard)
        }
    }

    @Test
    @DisplayName("Update identity card when successful")
    fun update_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_UPDATE
        assertDoesNotThrow {
            val response = identityCardService.update(identityCard)
            assertNotNull(response.id)
            assert(response == identityCard)
        }
    }

    @Test
    @DisplayName("Delete identity card by id when successful")
    fun deleteById_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_UPDATE
        assertDoesNotThrow {
            identityCardService.deleteById(identityCard.id)
        }
    }

}