package app.com.eiduca.module.candidacy.repository

import app.com.eiduca.module.academic.initializer.manager.CourseEntityManager
import app.com.eiduca.module.candidacy.common.datatimerange.DateTimeRangeRepositoryTest
import app.com.eiduca.module.candidacy.create.AccessExamCreate
import app.com.eiduca.module.candidacy.initializer.manager.CalendarAccessExamEntityManager
import app.com.eiduca.module.candidacy.model.AccessExam
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.core.util.AssertUtil
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@DisplayName("Test accessExam repository")
class AccessExamRepositoryTest(
    @Autowired var accessExamRepository: AccessExamRepository,
    @Autowired var testEntityManager: TestEntityManager
): DateTimeRangeRepositoryTest<AccessExam>(accessExamRepository, AccessExamCreate.ACCESS_EXAM_SAVE){

    @Test
    fun findByCourse_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(accessExamRepository.findByCourse(model.course))
    }

    @Test
    fun findByCourse_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(accessExamRepository.findByCourse(model.course, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByDiscipline_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(accessExamRepository.findByDiscipline(model.discipline))
    }

    @Test
    fun findByDiscipline_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(accessExamRepository.findByDiscipline(model.discipline, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCalendarAccessExam_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(accessExamRepository.findByCalendarAccessExam(model.calendarAccessExam))
    }

    @Test
    fun findByCalendarAccessExam_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(accessExamRepository.findByCalendarAccessExam(model.calendarAccessExam, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCourseAndDisciplineAndCalendarAccessExam_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(accessExamRepository.findByCourseAndDisciplineAndCalendarAccessExam(model.course, model.discipline, model.calendarAccessExam))
    }

    override fun persistModel() {
        model.course = testEntityManager.findOrSave(CourseEntityManager.initializer(testEntityManager, model.course))
        model.calendarAccessExam = testEntityManager.findOrSave(
            CalendarAccessExamEntityManager.initializer(testEntityManager, model.calendarAccessExam)
        )
        model.discipline = testEntityManager.findOrSave(model.discipline)
        model = testEntityManager.persistFlushFind(model)
    }
}