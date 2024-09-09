package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.ConcreteRepositoryTest
import app.com.eiduca.module.core.create.concrete.IdentityCardCreate
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of identity cards repository")
class IdentityCardRepositoryTest(
    @Autowired var identityCardRepository: IdentityCardRepository,
): ConcreteRepositoryTest<IdentityCard>(
    identityCardRepository, IdentityCardCreate.IDENTITY_CARD_SAVE
){

    @Autowired lateinit var personRepository: PersonRepository

    @Test
    @DisplayName("Find model identity cards by code when successful")
    fun findByCode_WhenSuccessful() {
        runner()
        persistModel()
        identityCardRepository.findByCode(model.code).ifPresentOrElse({
            assert(it.code == model.code)
        }, {throw NotFoundException("Not found IdentityCard by code") })
    }

    @Test
    @DisplayName("Find model identity cards by person when successful, return list")
    fun findByPerson_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByPerson(model.person))
    }

    @Test
    @DisplayName("Find model identity cards by person when successful, return list pageable")
    fun findByPerson_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByPerson(model.person, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find model identity cards by residential when successful, return list")
    fun findByResidential_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByResidential(model.residential))
    }

    @Test
    @DisplayName("Find model identity cards by residential when successful, return list pageable")
    fun findByResidential_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByResidential(model.residential, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find model identity cards by naturalFrom when successful, return list")
    fun findByNaturalFrom_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByNaturalFrom(model.naturalFrom))
    }

    @Test
    @DisplayName("Find model identity cards by naturalFrom when successful, return list pageable")
    fun findByNaturalFrom_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByNaturalFrom(model.naturalFrom, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find model identity cards by emittedFrom when successful, return list")
    fun findByEmittedFrom_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByEmittedFrom(model.emittedFrom))
    }

    @Test
    @DisplayName("Find model identity cards by emittedFrom when successful, return list pageable")
    fun findByEmittedFrom_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByEmittedFrom(model.emittedFrom, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find model identity cards by emittedAt when successful, return list")
    fun findByEmittedAt_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByEmittedAt(model.emittedAt))
    }

    @Test
    @DisplayName("Find model identity cards by emittedAt when successful, return list pageable")
    fun findByEmittedAt_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByEmittedAt(model.emittedAt, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find model identity cards by validAt when successful, return list")
    fun findByValidAt_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByValidAt(model.validAt))
    }

    @Test
    @DisplayName("Find model identity cards by validAt when successful, return list pageable")
    fun findByValidAt_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByValidAt(model.validAt, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find model identity cards by maritalStatus when successful, return list")
    fun findByMaritalStatus_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByMaritalStatus(model.maritalStatus))
    }

    @Test
    @DisplayName("Find model identity cards by maritalStatus when successful, return list pageable")
    fun findByMaritalStatus_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByMaritalStatus(model.maritalStatus, AssertUtil.PAGEABLE))
    }

    override fun runner() = identityCardRepository.deleteAll()

    override fun persistModel() {
        model.person = personRepository.findByIdentityCardNumber(model.person.identityCardNumber).orElse(personRepository.save(model.person))
        model = identityCardRepository.findByCode(model.code).orElse(identityCardRepository.save(model))
    }

}