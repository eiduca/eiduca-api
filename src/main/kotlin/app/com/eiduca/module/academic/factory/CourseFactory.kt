package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.CourseBuilder
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.Institution

class CourseFactory {
    companion object{
        fun build(name: String, code: String, institution: Institution, academicYear: AcademicYear): Course = CourseBuilder()
            .institution(institution)
            .academicYear(academicYear)
            .name(name)
            .code(code)
            .description("Academic Lective Year")
            .build()
    }
}