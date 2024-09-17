package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.model.concrete.*
import app.com.eiduca.module.core.common.general.ConcreteBuilder

class ClassroomBuilder: ConcreteBuilder<Classroom>() {

    private var code: String = ""
    private var course: Course = Course()
    private var dayPeriod: DayPeriod = DayPeriod()
    private var academicPeriod: AcademicPeriod = AcademicPeriod()
    private var curriculumYear: CurriculumYear = CurriculumYear()

    fun code(code: String) = apply { this.code = code }

    fun course(course: Course) = apply { this.course = course }

    fun dayPeriod(dayPeriod: DayPeriod) = apply { this.dayPeriod = dayPeriod }

    fun academicPeriod(academicPeriod: AcademicPeriod) = apply { this.academicPeriod = academicPeriod }

    fun curriculumYear(curriculumYear: CurriculumYear) = apply { this.curriculumYear = curriculumYear }

    override fun build(): Classroom {
        return withDefaultValues(Classroom(code, course, dayPeriod, academicPeriod, curriculumYear))
    }
}