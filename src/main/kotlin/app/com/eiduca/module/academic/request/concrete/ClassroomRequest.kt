package app.com.eiduca.module.academic.request.concrete

import app.com.eiduca.module.academic.builder.*
import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.module.core.interfaces.IConvertModel

data class ClassroomRequest(
    var code: String,
    var course: String,
    var dayPeriod: String,
    var academicPeriod: String,
    var curriculumYear: String,
): IConvertModel<Classroom>{
    override fun toModel() : Classroom = ClassroomBuilder()
        .curriculumYear(CurriculumYearBuilder().id(curriculumYear).build())
        .academicPeriod(AcademicPeriodBuilder().id(academicPeriod).build())
        .dayPeriod(DayPeriodBuilder().id(dayPeriod).build())
        .course(CourseBuilder().id(course).build())
        .code(code)
        .build()
}