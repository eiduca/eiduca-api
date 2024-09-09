package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.company.CompanyRepositoryTest
import app.com.eiduca.module.academic.create.concrete.InstitutionCreate
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of institution repository")
class InstitutionRepositoryTest(
    @Autowired val institutionRepository: InstitutionRepository,
    @Autowired val universityRepository: UniversityRepository
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

    override fun persistModel() {
        val university = model.university
        model.university =  universityRepository.findByName(university.name)
                                                .orElse(universityRepository.save(university))
        institutionRepository.findByName(model.name).orElse(institutionRepository.save(model))
    }

    override fun runner() = institutionRepository.deleteAll()
}