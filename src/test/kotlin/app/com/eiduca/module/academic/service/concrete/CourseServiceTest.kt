package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionServiceTest
import app.com.eiduca.module.academic.create.concrete.CourseCreate
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.repository.concrete.CourseRepository
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of course service")
class CourseServiceTest: CodeNamedDescriptionServiceTest<Course>() {
    @InjectMocks
    lateinit var courseService: CourseService
    @Mock
    lateinit var courseRepository: CourseRepository

    @BeforeEach
    fun setUp() {
        setUpCodeNamedDescription(courseService, courseRepository, CourseCreate.COURSE_SAVE)
        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(courseRepository.findByInstitution(model.institution)).thenReturn(list)
        BDDMockito.`when`(courseRepository.findByInstitution(model.institution, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(courseRepository.findByAcademicYear(model.academicYear)).thenReturn(list)
        BDDMockito.`when`(courseRepository.findByAcademicYear(model.academicYear, AssertUtil.PAGEABLE)).thenReturn(page)
    }

    @Test
    fun findByInstitution_ReturnList_WhenSuccessful() {
        AssertUtil.assert(courseService.findByInstitution(model.institution))
    }

    @Test
    fun findByInstitution_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(courseService.findByInstitution(model.institution, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByAcademicYear_ReturnList_WhenSuccessful() {
        AssertUtil.assert(courseService.findByAcademicYear(model.academicYear))
    }

    @Test
    fun findByAcademicYear_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(courseService.findByAcademicYear(model.academicYear, AssertUtil.PAGEABLE))
    }
}