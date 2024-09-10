package app.com.eiduca.module.academic.request.concrete

import app.com.eiduca.module.academic.builder.AcademicYearBuilder
import app.com.eiduca.module.academic.builder.CourseBuilder
import app.com.eiduca.module.academic.builder.InstitutionBuilder
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.core.interfaces.IConvertModel

data class CourseRequest(
    var code: String,
    var name: String,
    var description: String?,
    var institution: String,
    var academicYear: String,
): IConvertModel<Course>{
    override fun toModel() : Course = CourseBuilder()
        .institution(InstitutionBuilder().id(institution).build())
        .academicYear(AcademicYearBuilder().id(academicYear).build())
        .description(description)
        .name(name)
        .code(code)
        .build()
}