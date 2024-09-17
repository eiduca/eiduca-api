package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.dscipline.DisciplineRegimeProfileBuilder
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.CourseDiscipline

class CourseDisciplineBuilder: DisciplineRegimeProfileBuilder<CourseDiscipline>() {

    private var course: Course = Course()

    fun course(course: Course) = apply { this.course = course }

    override fun build(): CourseDiscipline {
        return withDefaultValues(CourseDiscipline(course, discipline, regimeDiscipline, profileDiscipline))
    }
}