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
    @DisplayName("Find person by email when successful")
    fun findByEmail_WhenSuccessful(){
        runner()
        persistModel()
        personRepository.findByEmail(model.email).ifPresentOrElse(
            { assert(it.email == model.email) },
            { throw NotFoundException("Not found person by email") }
        )
    }

    @Test
    @DisplayName("Find person by username when successful")
    fun findByUsername_WhenSuccessful(){
        runner()
        persistModel()
        personRepository.findByUsername(model.username).ifPresentOrElse(
            { assert(it.username == model.username) },
            { throw NotFoundException("Not found person by username") }
        )
    }

    @Test
    @DisplayName("Find person by identityCardNumber when successful")
    fun findByIdentityCardNumber_WhenSuccessful(){
        runner()
        persistModel()
        personRepository.findByIdentityCardNumber(model.identityCardNumber).ifPresentOrElse(
            { assert(it.identityCardNumber == model.identityCardNumber) },
            { throw NotFoundException("Not found person by identityCardNumber") }
        )
    }

    @Test
    @DisplayName("List person pageable by birthday when successful")
    fun findByBirthday_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(personRepository.findByBirthday(model.birthday, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("List person pageable by gender when successful")
    fun findByGender_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(personRepository.findByGender(model.gender, AssertUtil.PAGEABLE))
    }

    override fun persistModel() {
        model = personRepository.findByEmail(model.email).orElse(personRepository.save(model))
    }

    override fun runner() = personRepository.deleteAll()
}