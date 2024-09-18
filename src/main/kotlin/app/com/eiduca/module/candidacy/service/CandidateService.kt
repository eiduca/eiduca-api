package app.com.eiduca.module.candidacy.service

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.module.candidacy.repository.CandidateRepository
import app.com.eiduca.module.core.common.general.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.Person
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CandidateService(
    val candidateRepository: CandidateRepository
): ConcreteService<Candidate>(candidateRepository) {

    fun findByPerson(person: Person) = candidateRepository.findByPerson(person)

    fun findByPerson(person: Person, pageable: Pageable) = candidateRepository.findByPerson(person, pageable)

    fun findByCourse(course: Course) = candidateRepository.findByCourse(course)

    fun findByCourse(course: Course, pageable: Pageable) = candidateRepository.findByCourse(course, pageable)

    fun findByCalendarAccessExam(calendarAccessExam: CalendarAccessExam) = candidateRepository.findByCalendarAccessExam(calendarAccessExam)

    fun findByCalendarAccessExam(calendarAccessExam: CalendarAccessExam, pageable: Pageable) = candidateRepository.findByCalendarAccessExam(calendarAccessExam, pageable)

    fun findByPersonAndCourseAndCalendarAccessExam(person: Person, course: Course, calendarAccessExam: CalendarAccessExam): Candidate {
        return candidateRepository.findByPersonAndCourseAndCalendarAccessExam(person, course, calendarAccessExam).orElseThrow { NotFoundException("Not found Candidate by person, course, calendarAccessExam") }
    }

    override fun findOrSave(obj: Candidate): Candidate {
        return candidateRepository.findByPersonAndCourseAndCalendarAccessExam(obj.person, obj.course, obj.calendarAccessExam)
            .orElse(candidateRepository.save(obj))
    }

    override fun saveOrUpdate(obj: Candidate): Candidate {
        candidateRepository.findByPersonAndCourseAndCalendarAccessExam(obj.person, obj.course, obj.calendarAccessExam).ifPresent { obj.id = it.id }
        return candidateRepository.save(obj)
    }

    override fun deleteIfExist(obj: Candidate) {
        candidateRepository.findByPersonAndCourseAndCalendarAccessExam(obj.person, obj.course, obj.calendarAccessExam).ifPresent { hidden(it) }
    }

    override fun destroyIfExist(obj: Candidate) {
        candidateRepository.findByPersonAndCourseAndCalendarAccessExam(obj.person, obj.course, obj.calendarAccessExam).ifPresent { destroy(it) }
    }
}