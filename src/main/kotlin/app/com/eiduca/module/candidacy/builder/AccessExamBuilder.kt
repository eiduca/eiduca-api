package app.com.eiduca.module.candidacy.builder

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.candidacy.common.datatimerange.DateTimeRangeBuilder
import app.com.eiduca.module.candidacy.model.AccessExam
import app.com.eiduca.module.candidacy.model.CalendarAccessExam

class AccessExamBuilder: DateTimeRangeBuilder<AccessExam>() {

    private var course: Course = Course()
    private var discipline: Discipline = Discipline()
    private var calendarAccessExam: CalendarAccessExam = CalendarAccessExam()

    fun course(course: Course) = apply { this.course = course }

    fun discipline(discipline: Discipline) = apply { this.discipline = discipline }

    fun calendarAccessExam(calendarAccessExam: CalendarAccessExam) = apply { this.calendarAccessExam = calendarAccessExam }

    override fun build(): AccessExam {
        return withDefaultValues(AccessExam(course, discipline, calendarAccessExam, startDateTime, endDateTime))
    }
}