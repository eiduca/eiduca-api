package app.com.eiduca.module.candidacy.factory

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.candidacy.builder.AccessExamBuilder
import app.com.eiduca.module.candidacy.model.CalendarAccessExam

class AccessExamFactory {
    companion object{
        fun build(course: Course, discipline: Discipline, calendarAccessExam: CalendarAccessExam) = AccessExamBuilder()
            .course(course)
            .discipline(discipline)
            .calendarAccessExam(calendarAccessExam)
            .build()
    }
}