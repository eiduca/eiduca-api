package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import app.com.eiduca.module.core.create.concrete.PersonCreate
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.request.PersonRequest
import app.com.eiduca.module.core.service.concrect.PersonService

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of person controller")
class PersonControllerTest: ConcreteControllerTest<Person, PersonRequest>() {

    @InjectMocks
    lateinit var personController: PersonController

    @Mock
    lateinit var personService: PersonService

    @BeforeEach
    fun setUpPerson() {
        setUpConcrete(personController, personService, PersonCreate.PERSON_SAVE)
    }

    override fun createModel(): ResponseEntity<Person> = personController.save(model.toRequest())

    override fun updateModel(): ResponseEntity<Person> = personController.update(model.toRequest(), model.id)
}