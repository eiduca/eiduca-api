package app.com.eiduca.module.candidacy.repository

import app.com.eiduca.module.candidacy.create.CandidateCreate
import app.com.eiduca.module.candidacy.initializer.manager.CandidateEntityManager
import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@DisplayName("Test candidate repository")
class CandidateRepositoryTest(
    @Autowired var candidateRepository: CandidateRepository,
    @Autowired var testEntityManager: TestEntityManager
): ConcreteRepositoryTest<Candidate>(candidateRepository, CandidateCreate.CANDIDATE_SAVE) {

    @Test
    fun findByPerson_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(candidateRepository.findByPerson(model.person))
    }

    @Test
    fun findByPerson_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(candidateRepository.findByPerson(model.person, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCourse_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(candidateRepository.findByCourse(model.course))
    }

    @Test
    fun findByCourse_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(candidateRepository.findByCourse(model.course, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCalendarAccessExam_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(candidateRepository.findByCalendarAccessExam(model.calendarAccessExam))
    }

    @Test
    fun findByCalendarAccessExam_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(candidateRepository.findByCalendarAccessExam(model.calendarAccessExam, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByPersonAndCourseAndCalendarAccessExam_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(candidateRepository.findByPersonAndCourseAndCalendarAccessExam(model.person, model.course, model.calendarAccessExam))
    }

    override fun persistModel() {
        model = CandidateEntityManager.initializer(testEntityManager, model)
        model = testEntityManager.persistFlushFind(model)
    }
}