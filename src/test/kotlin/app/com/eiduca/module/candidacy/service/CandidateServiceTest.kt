package app.com.eiduca.module.candidacy.service

import app.com.eiduca.module.candidacy.create.CandidateCreate
import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.module.candidacy.repository.CandidateRepository
import app.com.eiduca.module.core.common.general.ConcreteServiceTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageImpl
import java.util.*

@DataJpaTest
@DisplayName("Test candidate service")
class CandidateServiceTest: ConcreteServiceTest<Candidate>() {
    @InjectMocks
    lateinit var candidateService: CandidateService
    @Mock
    lateinit var candidateRepository: CandidateRepository

    @BeforeEach
    fun setUp(){
        setUpConcrete(candidateService, candidateRepository, CandidateCreate.CANDIDATE_SAVE)

        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(candidateRepository.findByPerson(model.person)).thenReturn(list)
        BDDMockito.`when`(candidateRepository.findByPerson(model.person, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(candidateRepository.findByCourse(model.course)).thenReturn(list)
        BDDMockito.`when`(candidateRepository.findByCourse(model.course, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(candidateRepository.findByCalendarAccessExam(model.calendarAccessExam)).thenReturn(list)
        BDDMockito.`when`(candidateRepository.findByCalendarAccessExam(model.calendarAccessExam, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(candidateRepository.findByPersonAndCourseAndCalendarAccessExam(model.person, model.course, model.calendarAccessExam)).thenReturn(Optional.of(model))
    }

    @Test
    fun findByPerson_ReturnList_WhenSuccessful() {
        AssertUtil.assert(candidateRepository.findByPerson(model.person))
    }

    @Test
    fun findByPerson_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(candidateRepository.findByPerson(model.person, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCourse_ReturnList_WhenSuccessful() {
        AssertUtil.assert(candidateRepository.findByCourse(model.course))
    }

    @Test
    fun findByCourse_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(candidateRepository.findByCourse(model.course, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCalendarAccessExam_ReturnList_WhenSuccessful() {
        AssertUtil.assert(candidateRepository.findByCalendarAccessExam(model.calendarAccessExam))
    }

    @Test
    fun findByCalendarAccessExam_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(candidateRepository.findByCalendarAccessExam(model.calendarAccessExam, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByPersonAndCourseAndCalendarAccessExam_ReturnObject_WhenSuccessful() {
        AssertUtil.assert(candidateRepository.findByPersonAndCourseAndCalendarAccessExam(model.person, model.course ,model.calendarAccessExam))
    }
}