package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.general.ConcreteServiceTest
import app.com.eiduca.module.core.create.concrete.PersonCreate
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.repository.concrect.PersonRepository
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.Optional
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@ExtendWith(SpringExtension::class)
@DisplayName("Test of person service")
class PersonServiceTest: ConcreteServiceTest<Person>(){

    @InjectMocks
    lateinit var personService: PersonService

    @Mock
    lateinit var personRepository: PersonRepository

    @BeforeEach
    fun setUp() {
        setUpConcrete(personService, personRepository, PersonCreate.PERSON_SAVE)
        BDDMockito.`when`(personRepository.findByUsername(model.username)).thenReturn(Optional.of(model))
        BDDMockito.`when`(personRepository.findByEmail(model.email)).thenReturn(Optional.of(model))

        BDDMockito.`when`(personRepository.findByGender(model.gender, AssertUtil.PAGEABLE)).thenReturn(PageImpl(mutableListOf(model)))
        BDDMockito.`when`(personRepository.findByBirthday(model.birthday, AssertUtil.PAGEABLE)).thenReturn(PageImpl(mutableListOf(model)))
    }

    @Test
    @DisplayName("Find person by username when successful")
    fun findByUsername_WhenSuccessful() {
        assertDoesNotThrow {
            val response = personService.findByUsername(model.username)
            assertEquals(response.username, model.username)
        }
    }

    @Test
    @DisplayName("Find person by email when successful")
    fun findByEmail_WhenSuccessful() {
        assertDoesNotThrow {
            val response = personService.findByEmail(model.email)
            assertEquals(response.email, model.email)
        }
    }

    @Test
    @DisplayName("List pageable persons by gender when successful")
    fun findByGender_WhenSuccessful() {
        assertDoesNotThrow {
            AssertUtil.assert(personService.findByGender(model.gender, AssertUtil.PAGEABLE))
        }
    }

    @Test
    @DisplayName("List pageable persons by birthday when successful")
    fun findByBirthday_WhenSuccessful() {
        assertDoesNotThrow {
            AssertUtil.assert(personService.findByBirthday(model.birthday, AssertUtil.PAGEABLE))
        }
    }

    @Test
    @DisplayName("Create or update person when successful")
    fun saveOrUpdate_WhenSuccessful() {
        assertDoesNotThrow {
            val response = personService.saveOrUpdate(model)
            assertNotNull(response.id)
            assertEquals(response.identityCardNumber, model.identityCardNumber)
        }
    }
}