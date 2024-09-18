package app.com.eiduca.module.candidacy.repository

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.module.candidacy.query.CandidateJPQL
import app.com.eiduca.module.core.common.general.ConcreteRepository
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.query.EntityJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CandidateRepository: ConcreteRepository<Candidate> {

    @Query(name = EntityJPQL.FIND_ALL_PERSON)
    fun findByPerson(person: Person): List<Candidate>

    @Query(name = EntityJPQL.FIND_ALL_PERSON, countName = EntityJPQL.FIND_COUNT_PERSON)
    fun findByPerson(person: Person, pageable: Pageable): Page<Candidate>

    @Query(name = EntityJPQL.FIND_ALL_COURSE)
    fun findByCourse(course: Course): List<Candidate>

    @Query(name = EntityJPQL.FIND_ALL_COURSE, countName = EntityJPQL.FIND_COUNT_COURSE)
    fun findByCourse(course: Course, pageable: Pageable): Page<Candidate>

    @Query(name = EntityJPQL.FIND_ALL_CALENDAR_ACCESS_EXAM)
    fun findByCalendarAccessExam(calendarAccessExam: CalendarAccessExam): List<Candidate>

    @Query(name = EntityJPQL.FIND_ALL_CALENDAR_ACCESS_EXAM, countName = EntityJPQL.FIND_COUNT_CALENDAR_ACCESS_EXAM)
    fun findByCalendarAccessExam(calendarAccessExam: CalendarAccessExam, pageable: Pageable): Page<Candidate>

    @Query(name = CandidateJPQL.FIND_BY_PERSON_AND_COURSE_CALENDAR_ACCESS_EXAM)
    fun findByPersonAndCourseAndCalendarAccessExam(person: Person, course: Course, calendarAccessExam: CalendarAccessExam): Optional<Candidate>
}