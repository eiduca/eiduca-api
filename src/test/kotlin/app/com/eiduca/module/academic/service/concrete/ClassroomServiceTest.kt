package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.create.concrete.ClassroomCreate
import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.module.academic.repository.concrete.ClassroomRepository
import app.com.eiduca.module.core.common.general.ConcreteServiceTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageImpl
import java.util.*

@DataJpaTest
@DisplayName("Test of classroom service")
class ClassroomServiceTest: ConcreteServiceTest<Classroom>() {
    @InjectMocks
    lateinit var classroomService: ClassroomService
    @Mock
    lateinit var classroomRepository: ClassroomRepository

    @BeforeEach
    fun setUp() {
        setUpConcrete(classroomService, classroomRepository, ClassroomCreate.CLASSROOM_SAVE)
        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(classroomRepository.findByCode(model.code)).thenReturn(Optional.of(model))
        BDDMockito.`when`(classroomRepository.findByCourse(model.course)).thenReturn(list)
        BDDMockito.`when`(classroomRepository.findByCourse(model.course, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(classroomRepository.findByDayPeriod(model.dayPeriod)).thenReturn(list)
        BDDMockito.`when`(classroomRepository.findByDayPeriod(model.dayPeriod, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(classroomRepository.findByAcademicPeriod(model.academicPeriod)).thenReturn(list)
        BDDMockito.`when`(classroomRepository.findByAcademicPeriod(model.academicPeriod, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(classroomRepository.findByCurriculumYear(model.curriculumYear)).thenReturn(list)
        BDDMockito.`when`(classroomRepository.findByCurriculumYear(model.curriculumYear, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(classroomRepository.findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear(model.course, model.dayPeriod, model.academicPeriod, model.curriculumYear)).thenReturn(Optional.of(model))
    }

    @Test
    fun findByCode_ReturnObject_WhenSuccessful() {
        assertDoesNotThrow {
            val classroomSave = classroomService.findOrSave(model)
            val classroomFound = classroomService.findByCode(model.code)
            assertEquals(classroomSave, classroomFound)
        }
    }

    @Test
    fun findByCourse_ReturnList_WhenSuccessful() {
        AssertUtil.assert(classroomService.findByCourse(model.course))
    }

    @Test
    fun findByCourse_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(classroomService.findByCourse(model.course, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByDayPeriod_ReturnList_WhenSuccessful() {
        AssertUtil.assert(classroomService.findByDayPeriod(model.dayPeriod))
    }

    @Test
    fun findByDayPeriod_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(classroomService.findByDayPeriod(model.dayPeriod, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByAcademicPeriod_ReturnList_WhenSuccessful() {
        AssertUtil.assert(classroomService.findByAcademicPeriod(model.academicPeriod))
    }

    @Test
    fun findByAcademicPeriod_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(classroomService.findByAcademicPeriod(model.academicPeriod, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCurriculumYear_ReturnList_WhenSuccessful() {
        AssertUtil.assert(classroomService.findByCurriculumYear(model.curriculumYear))
    }

    @Test
    fun findByCurriculumYear_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(classroomService.findByCurriculumYear(model.curriculumYear, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear_ReturnClassroom_WhenSuccessful() {
        assertDoesNotThrow {
            val classroomSave = classroomService.findOrSave(model)
            val classroomFound = classroomService.findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear(
                model.course,
                model.dayPeriod,
                model.academicPeriod,
                model.curriculumYear
            )
            assertEquals(classroomSave, classroomFound)
        }
    }
}