package app.com.eiduca.module.academic.common.dscipline

import app.com.eiduca.module.core.common.general.ConcreteServiceTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.mockito.BDDMockito
import org.springframework.data.domain.PageImpl

@DisplayName("Test disciplineRegimeProfile service")
abstract class DisciplineRegimeProfileServiceTest<T: DisciplineRegimeProfileModel>: ConcreteServiceTest<T>() {

    private lateinit var disciplineRegimeProfileService: DisciplineRegimeProfileService<T>
    private lateinit var disciplineRegimeProfileRepository: DisciplineRegimeProfileRepository<T>

    fun setUpDisciplineRegimeProfile(disciplineRegimeProfileService: DisciplineRegimeProfileService<T>, disciplineRegimeProfileRepository: DisciplineRegimeProfileRepository<T>, model: T){
        setUpConcrete(disciplineRegimeProfileService, disciplineRegimeProfileRepository, model)

        this.disciplineRegimeProfileRepository = disciplineRegimeProfileRepository
        this.disciplineRegimeProfileService = disciplineRegimeProfileService
        this.model = model

        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(disciplineRegimeProfileRepository.findByDiscipline(model.discipline)).thenReturn(list)
        BDDMockito.`when`(disciplineRegimeProfileRepository.findByDiscipline(model.discipline, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(disciplineRegimeProfileRepository.findByRegimeDiscipline(model.regimeDiscipline)).thenReturn(list)
        BDDMockito.`when`(disciplineRegimeProfileRepository.findByRegimeDiscipline(model.regimeDiscipline, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(disciplineRegimeProfileRepository.findByProfileDiscipline(model.profileDiscipline)).thenReturn(list)
        BDDMockito.`when`(disciplineRegimeProfileRepository.findByProfileDiscipline(model.profileDiscipline, AssertUtil.PAGEABLE)).thenReturn(page)
    }

    @Test
    fun findByDiscipline_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileService.findByDiscipline(model.discipline))
    }

    @Test
    fun findByDiscipline_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileService.findByDiscipline(model.discipline, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByRegimeDiscipline_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileService.findByRegimeDiscipline(model.regimeDiscipline))
    }

    @Test
    fun findByRegimeDiscipline_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileService.findByRegimeDiscipline(model.regimeDiscipline, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByProfileDiscipline_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileService.findByProfileDiscipline(model.profileDiscipline))
    }

    @Test
    fun findByProfileDiscipline_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(disciplineRegimeProfileService.findByProfileDiscipline(model.profileDiscipline, AssertUtil.PAGEABLE))
    }
}