package app.com.eiduca.module.candidacy.repository

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.candidacy.common.datatimerange.DateTimeRangeRepository
import app.com.eiduca.module.candidacy.model.AccessExam
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.candidacy.query.AccessExamJPQL
import app.com.eiduca.module.core.query.EntityJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AccessExamRepository: DateTimeRangeRepository<AccessExam> {

    @Query(name = EntityJPQL.FIND_ALL_COURSE)
    fun findByCourse(course: Course): List<AccessExam>

    @Query(name = EntityJPQL.FIND_ALL_COURSE, countName = EntityJPQL.FIND_COUNT_COURSE)
    fun findByCourse(course: Course, pageable: Pageable): Page<AccessExam>

    @Query(name = EntityJPQL.FIND_ALL_DISCIPLINE)
    fun findByDiscipline(discipline: Discipline): List<AccessExam>

    @Query(name = EntityJPQL.FIND_ALL_DISCIPLINE, countName = EntityJPQL.FIND_COUNT_DISCIPLINE)
    fun findByDiscipline(discipline: Discipline, pageable: Pageable): Page<AccessExam>

    @Query(name = EntityJPQL.FIND_ALL_CALENDAR_ACCESS_EXAM)
    fun findByCalendarAccessExam(calendarAccessExam: CalendarAccessExam): List<AccessExam>

    @Query(name = EntityJPQL.FIND_ALL_CALENDAR_ACCESS_EXAM, countName = EntityJPQL.FIND_COUNT_CALENDAR_ACCESS_EXAM)
    fun findByCalendarAccessExam(calendarAccessExam: CalendarAccessExam, pageable: Pageable): Page<AccessExam>

    @Query(name = AccessExamJPQL.FIND_BY_COURSE_DISCIPLINE_CALENDAR_ACCESS_EXAM)
    fun findByCourseAndDisciplineAndCalendarAccessExam(course: Course, discipline: Discipline, calendarAccessExam: CalendarAccessExam): Optional<AccessExam>
}