package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.company.CompanyModel
import app.com.eiduca.module.academic.common.company.CompanyRepositoryTest
import app.com.eiduca.module.academic.create.concrete.InstitutionCreate
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.core.common.general.CommonModel
import app.com.eiduca.module.core.util.AssertUtil
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
    @DisplayName("Find institution by type when successful, return list")
    fun findByType_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(institutionRepository.findByType(model.type))
    }

    @Test
    @DisplayName("Find institution by type when successful, return list pageable")
    fun findByType_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(institutionRepository.findByType(model.type, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find institution by university and name when successful")
    fun findByNameAndUniversity_WhenSuccessful(){
        runner()
        persistModel()
        AssertUtil.assert(institutionRepository.findByNameAndUniversity(model.name, model.university))
    }

    override fun runner() = institutionRepository.deleteAll()

    override fun persistModel() {
        model.university = testEntityManager.findOrSave(model.university)
        model = testEntityManager.persistFlushFind(model)
    }

    fun <T: CommonModel> TestEntityManager.findOrSave(entity: T): T {
        if(entity is CompanyModel) return this.entityManager.find(entity::class.java, entity.name) ?: this.persistAndFlush(entity)
        return this.entityManager.find(entity::class.java, entity.id) ?: this.persistAndFlush(entity)
    }
}