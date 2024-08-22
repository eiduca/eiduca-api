package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.concrete.PersonCreate
import app.com.eiduca.module.core.seed.concrete.PersonSeed
import app.com.eiduca.module.core.service.concrect.PersonService
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of person controller")
class PersonControllerTest {

    @InjectMocks
    lateinit var personController: PersonController

    @Mock
    lateinit var personService: PersonService

    @BeforeEach
    fun setUp() {
        val person = PersonCreate.PERSON_SAVE
        val personPage = PageImpl(PersonSeed.entries.map { it.person })
        BDDMockito.`when`(personService.findAll(Pageable.ofSize(15))).thenReturn(personPage)
        BDDMockito.`when`(personService.findById(ArgumentMatchers.anyString())).thenReturn(person)
        BDDMockito.`when`(personService.save(person)).thenReturn(person)
        BDDMockito.doNothing().`when`(personService).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of persons when successful")
    fun findAll_WhenSuccessful() {
        val response = personController.findAll(Pageable.ofSize(15))
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.isEmpty?.let { assertFalse(it) }
    }

    @Test
    @DisplayName("Find person by id when successful")
    fun findById_WhenSuccessful() {
        val person = PersonCreate.PERSON_SAVE
        val response = personController.findById(person.id)
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.let { assert(person.id == it.id) }
    }

    @Test
    @DisplayName("Create person when successful")
    fun save_WhenSuccessful() {
        val person = PersonCreate.PERSON_SAVE
        val response = personController.save(person.toPersonRequestPost())
        assertTrue(response.statusCode == ReturnStatus.CREATED)
        response.body?.let { assert(person.identityCardNumber == it.identityCardNumber) }
    }

    @Test
    @DisplayName("Update person when successful")
    fun update_WhenSuccessful() {
        val person = PersonCreate.PERSON_UPDATE
        val response = personController.update(person.toPersonRequestPut())
        assertTrue(response.statusCode == ReturnStatus.UPDATED)
        response.body?.let { assert(person.identityCardNumber == it.identityCardNumber) }
    }

    @Test
    @DisplayName("Delete person by id when successful")
    fun deleteById_WhenSuccessful() {
        val person = PersonCreate.PERSON_UPDATE
        val response = personController.deleteById(person.id)
        assertTrue(response.statusCode == ReturnStatus.DELETED)
    }
}