package app.com.eiduca.module.candidacy.repository

import app.com.eiduca.module.academic.common.datarange.DataRangeRepositoryTest
import app.com.eiduca.module.candidacy.CalendarAccessExamCreate
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.util.AssertUtil
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@DisplayName("Test calendarAccessExam repository")
class CalendarAccessExamRepositoryTest(
    @Autowired var calendarAccessExamRepository: CalendarAccessExamRepository,
    @Autowired var testEntityManager: TestEntityManager
): DataRangeRepositoryTest<CalendarAccessExam>(calendarAccessExamRepository, CalendarAccessExamCreate.CALENDAR_ACCESS_EXAM_SAVE) {

    @Test
    fun findByNumb_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(calendarAccessExamRepository.findByNumb(model.numb))
    }

    @Test
    fun findByNumb_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(calendarAccessExamRepository.findByNumb(model.numb, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByAcademicYear_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(calendarAccessExamRepository.findByAcademicYear(model.academicYear))
    }

    @Test
    fun findByAcademicYear_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(calendarAccessExamRepository.findByAcademicYear(model.academicYear, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByNumbAndAcademicYear_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        calendarAccessExamRepository.findByNumbAndAcademicYear(model.numb, model.academicYear).ifPresentOrElse({
            assert(it == model)
        }, {throw NotFoundException("Not found calendarAccessExam by numb, academicYear") })
    }

    override fun persistModel() {
        model.academicYear = testEntityManager.findOrSave(model.academicYear)
        model = testEntityManager.persistFlushFind(model)
    }
}