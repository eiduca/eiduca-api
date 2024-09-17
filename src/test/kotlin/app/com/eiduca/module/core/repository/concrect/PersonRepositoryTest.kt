package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.create.concrete.PersonCreate
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of person repository")
class PersonRepositoryTest(
    @Autowired val personRepository: PersonRepository
): ConcreteRepositoryTest<Person>(
    personRepository, PersonCreate.PERSON_SAVE
){

    @Test
    fun findByEmail_ReturnObject_WhenSuccessful(){
        runner()
        persistModel()
        personRepository.findByEmail(model.email).ifPresentOrElse(
            { assert(it.email == model.email) },
            { throw NotFoundException("Not found person by email") }
        )
    }

    @Test
    fun findByUsername_ReturnObject_WhenSuccessful(){
        runner()
        persistModel()
        personRepository.findByUsername(model.username).ifPresentOrElse(
            { assert(it.username == model.username) },
            { throw NotFoundException("Not found person by username") }
        )
    }

    @Test
    fun findByIdentityCardNumber_ReturnObject_WhenSuccessful(){
        runner()
        persistModel()
        personRepository.findByIdentityCardNumber(model.identityCardNumber).ifPresentOrElse(
            { assert(it.identityCardNumber == model.identityCardNumber) },
            { throw NotFoundException("Not found person by identityCardNumber") }
        )
    }

    @Test
    fun findByBirthday_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(personRepository.findByBirthday(model.birthday, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByGender_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(personRepository.findByGender(model.gender, AssertUtil.PAGEABLE))
    }

    override fun persistModel() {
        model = personRepository.findByEmail(model.email).orElse(personRepository.save(model))
    }

    override fun runner() = personRepository.deleteAll()
}