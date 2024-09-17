package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.company.CompanyRepositoryTest
import app.com.eiduca.module.academic.create.concrete.InstitutionCreate
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.core.util.AssertUtil
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@DisplayName("Test of institution repository")
class InstitutionRepositoryTest(
    @Autowired val institutionRepository: InstitutionRepository,
    @Autowired var testEntityManager: TestEntityManager
): CompanyRepositoryTest<Institution>(institutionRepository,InstitutionCreate.INSTITUTION_SAVE) {

    @Test
    fun findByType_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(institutionRepository.findByType(model.type))
    }

    @Test
    fun findByType_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(institutionRepository.findByType(model.type, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByNameAndUniversity_ReturnObject_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(institutionRepository.findByNameAndUniversity(model.name, model.university))
    }

    override fun runner() = institutionRepository.deleteAll()

    override fun persistModel() {
        model.university = testEntityManager.findOrSave(model.university)
        model = testEntityManager.persistFlushFind(model)
    }
}