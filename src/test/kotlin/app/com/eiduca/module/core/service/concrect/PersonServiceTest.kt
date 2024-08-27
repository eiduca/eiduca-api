package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.create.concrete.PersonCreate
import app.com.eiduca.module.core.repository.concrect.PersonRepository
import app.com.eiduca.module.core.seed.PersonSeed
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.Optional
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@ExtendWith(SpringExtension::class)
@DisplayName("Test of person service")
class PersonServiceTest{

    @InjectMocks
    lateinit var personService: PersonService

    @Mock
    lateinit var personRepository: PersonRepository

    @BeforeEach
    fun setUp() {
        val person = PersonCreate.PERSON_SAVE
        val personPage = PageImpl(PersonSeed.entries.map { it.person })
        BDDMockito.`when`(personRepository.findAll(Pageable.ofSize(15))).thenReturn(personPage)
        BDDMockito.`when`(personRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(person))
        BDDMockito.`when`(personRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(Optional.of(person))
        BDDMockito.`when`(personRepository.save(person)).thenReturn(person)
        BDDMockito.doNothing().`when`(personRepository).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of persons when successful")
    fun findAll_WhenSuccessful() {
        val response = personService.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find person by id when successful")
    fun findById_WhenSuccessful() {
        val person = PersonCreate.PERSON_SAVE
        assertDoesNotThrow {
            val response = personService.findById(person.id)
            assertEquals(response.id, person.id)
        }
    }

    @Test
    @DisplayName("Find person by username when successful")
    fun findByUsername_WhenSuccessful() {
        val person = PersonCreate.PERSON_SAVE
        assertDoesNotThrow {
            val response = personService.findByUsername(person.username)
            assertEquals(response.username, person.username)
        }
    }

    @Test
    @DisplayName("Create person when successful")
    fun save_WhenSuccessful() {
        val person = PersonCreate.PERSON_SAVE
        assertDoesNotThrow {
            val response = personService.save(person)
            assertNotNull(response.id)
            assertEquals(response.identityCardNumber, person.identityCardNumber)
        }
    }

    @Test
    @DisplayName("Create or update person when successful")
    fun saveOrUpdate_WhenSuccessful() {
        val person = PersonCreate.PERSON_SAVE
        assertDoesNotThrow {
            val response = personService.saveOrUpdate(person)
            assertNotNull(response.id)
            assertEquals(response.identityCardNumber, person.identityCardNumber)
        }
    }

    @Test
    @DisplayName("Update person when successful")
    fun update_WhenSuccessful() {
        val person = PersonCreate.PERSON_UPDATE
        assertDoesNotThrow {
            val response = personService.update(person)
            assertNotNull(response.id)
            assert(response == person)
        }
    }

    @Test
    @DisplayName("Delete person by id when successful")
    fun deleteById_WhenSuccessful() {
        val person = PersonCreate.PERSON_UPDATE
        assertDoesNotThrow {
            personService.deleteById(person.id)
        }
    }
}