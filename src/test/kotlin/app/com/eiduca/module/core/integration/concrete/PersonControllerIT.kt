package app.com.eiduca.module.core.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import app.com.eiduca.module.core.create.concrete.PersonCreate
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.request.PersonRequest
import app.com.eiduca.module.core.service.concrect.PersonService
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of person")
class PersonControllerIT(
    @Autowired val personService: PersonService,
): ConcreteControllerItTest<Person>(
    personService,
    PersonCreate.PERSON_SAVE,
    "persons"
) {
    override fun requestModel(): PersonRequest = model.toRequest()
}