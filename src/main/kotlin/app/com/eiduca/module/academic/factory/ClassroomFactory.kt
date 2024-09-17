package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.ClassroomBuilder
import app.com.eiduca.module.academic.model.concrete.*

class ClassroomFactory {
    companion object{
        fun build(code: String, course: Course, dayPeriod: DayPeriod, academicPeriod: AcademicPeriod, curriculumYear: CurriculumYear): Classroom = ClassroomBuilder()
            .curriculumYear(curriculumYear)
            .academicPeriod(academicPeriod)
            .dayPeriod(dayPeriod)
            .course(course)
            .code(code)
            .build()
    }
}