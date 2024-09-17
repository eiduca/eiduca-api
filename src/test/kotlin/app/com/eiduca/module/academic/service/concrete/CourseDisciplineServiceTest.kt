package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.dscipline.DisciplineRegimeProfileServiceTest
import app.com.eiduca.module.academic.create.concrete.CourseDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.CourseDiscipline
import app.com.eiduca.module.academic.repository.concrete.CourseDisciplineRepository
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageImpl

@DataJpaTest
@DisplayName("Test of courseDiscipline service")
class CourseDisciplineServiceTest: DisciplineRegimeProfileServiceTest<CourseDiscipline>() {
    @InjectMocks
    lateinit var courseDisciplineService: CourseDisciplineService
    @Mock
    lateinit var courseDisciplineRepository: CourseDisciplineRepository

    @BeforeEach
    fun setUp(){
        setUpDisciplineRegimeProfile(courseDisciplineService, courseDisciplineRepository, CourseDisciplineCreate.COURSE_DISCIPLINE_SAVE)
        this.courseDisciplineRepository = courseDisciplineRepository
        this.courseDisciplineService = courseDisciplineService

        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(courseDisciplineRepository.findByCourse(model.course)).thenReturn(list)
        BDDMockito.`when`(courseDisciplineRepository.findByCourse(model.course, AssertUtil.PAGEABLE)).thenReturn(page)
    }

    @Test
    fun findByCourse_ReturnList_WhenSuccessful() {
        AssertUtil.assert(courseDisciplineService.findByCourse(model.course))
    }

    @Test
    fun findByCourse_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(courseDisciplineService.findByCourse(model.course, AssertUtil.PAGEABLE))
    }
}