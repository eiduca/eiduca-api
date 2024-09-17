package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
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
    @Autowired var personRepository: PersonRepository
): ConcreteRepositoryTest<IdentityCard>(
    identityCardRepository, IdentityCardCreate.IDENTITY_CARD_SAVE
){

    @Test
    fun findByCode_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        identityCardRepository.findByCode(model.code).ifPresentOrElse({
            assert(it.code == model.code)
        }, {throw NotFoundException("Not found IdentityCard by code") })
    }

    @Test
    fun findByPerson_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByPerson(model.person))
    }

    @Test
    fun findByPerson_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByPerson(model.person, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByResidential_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByResidential(model.residential))
    }

    @Test
    fun findByResidential_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByResidential(model.residential, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByNaturalFrom_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByNaturalFrom(model.naturalFrom))
    }

    @Test
    fun findByNaturalFrom_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByNaturalFrom(model.naturalFrom, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByEmittedFrom_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByEmittedFrom(model.emittedFrom))
    }

    @Test
    fun findByEmittedFrom_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByEmittedFrom(model.emittedFrom, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByEmittedAt_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByEmittedAt(model.emittedAt))
    }

    @Test
    fun findByEmittedAt_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByEmittedAt(model.emittedAt, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByValidAt_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByValidAt(model.validAt))
    }

    @Test
    fun findByValidAt_ReturnPage_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByValidAt(model.validAt, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByMaritalStatus_ReturnList_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(identityCardRepository.findByMaritalStatus(model.maritalStatus))
    }

    @Test
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