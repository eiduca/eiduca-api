package app.com.eiduca.module.candidacy.service

import app.com.eiduca.module.academic.common.datarange.DataRangeServiceTest
import app.com.eiduca.module.candidacy.create.CalendarAccessExamCreate
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.candidacy.repository.CalendarAccessExamRepository
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageImpl
import java.util.Optional

@DataJpaTest
@DisplayName("Test of calendarAccessExam service")
class CalendarAccessExamServiceTest: DataRangeServiceTest<CalendarAccessExam>() {
    @InjectMocks
    lateinit var calendarAccessExamService: CalendarAccessExamService
    @Mock
    lateinit var calendarAccessExamRepository: CalendarAccessExamRepository

    @BeforeEach
    fun setUp(){
        setUpDateRange(calendarAccessExamService, calendarAccessExamRepository, CalendarAccessExamCreate.CALENDAR_ACCESS_EXAM_SAVE)

        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(calendarAccessExamRepository.findByNumb(model.numb)).thenReturn(list)
        BDDMockito.`when`(calendarAccessExamRepository.findByNumb(model.numb, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(calendarAccessExamRepository.findByAcademicYear(model.academicYear)).thenReturn(list)
        BDDMockito.`when`(calendarAccessExamRepository.findByAcademicYear(model.academicYear, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(calendarAccessExamRepository.findByNumbAndAcademicYear( model.numb, model.academicYear)).thenReturn(Optional.of(model))
    }

    @Test
    fun findByNumb_ReturnList_WhenSuccessful() {
        AssertUtil.assert(calendarAccessExamService.findByNumb(model.numb))
    }

    @Test
    fun findByNumb_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(calendarAccessExamService.findByNumb(model.numb, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByAcademicYear_ReturnList_WhenSuccessful() {
        AssertUtil.assert(calendarAccessExamService.findByAcademicYear(model.academicYear))
    }

    @Test
    fun findByAcademicYear_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(calendarAccessExamService.findByAcademicYear(model.academicYear, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByNumbAndAcademicYear_ReturnObject_WhenSuccessful() {
        AssertUtil.assert(calendarAccessExamService.findByNumbAndAcademicYear(model.numb, model.academicYear))
    }
}