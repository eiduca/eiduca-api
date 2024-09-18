package app.com.eiduca.module.candidacy.builder

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.candidacy.common.datatimerange.DateTimeRangeBuilder
import app.com.eiduca.module.candidacy.model.AccessExam

class AccessExamBuilder: DateTimeRangeBuilder<AccessExam>() {

    private var course: Course = Course()
    private var discipline: Discipline = Discipline()

    fun course(course: Course) = apply { this.course = course }

    fun discipline(discipline: Discipline) = apply { this.discipline = discipline }

    override fun build(): AccessExam {
        return withDefaultValues(AccessExam(course, discipline, startDateTime, endDateTime))
    }
}