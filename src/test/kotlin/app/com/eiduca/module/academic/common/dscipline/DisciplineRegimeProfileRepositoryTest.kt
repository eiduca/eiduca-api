package app.com.eiduca.module.academic.common.dscipline

import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

@DisplayName("Test disciplineRegimeProfile repository")
abstract class DisciplineRegimeProfileRepositoryTest<T: DisciplineRegimeProfileModel>(
    var disciplineRegimeProfileRepository: DisciplineRegimeProfileRepository<T>,
    model: T
): ConcreteRepositoryTest<T>(disciplineRegimeProfileRepository, model) {

    @Test
    fun findByDiscipline_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileRepository.findByDiscipline(model.discipline))
    }

    @Test
    fun findByDiscipline_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileRepository.findByDiscipline(model.discipline, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByRegimeDiscipline_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileRepository.findByRegimeDiscipline(model.regimeDiscipline))
    }

    @Test
    fun findByRegimeDiscipline_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileRepository.findByRegimeDiscipline(model.regimeDiscipline, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByProfileDiscipline_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileRepository.findByProfileDiscipline(model.profileDiscipline))
    }

    @Test
    fun findByProfileDiscipline_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileRepository.findByProfileDiscipline(model.profileDiscipline, AssertUtil.PAGEABLE))
    }
}