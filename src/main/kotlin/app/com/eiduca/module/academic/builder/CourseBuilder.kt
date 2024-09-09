package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionBuilder
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.Institution

class CourseBuilder: CodeNamedDescriptionBuilder<Course>() {
    private var institution: Institution = Institution()
    private  var academicYear: AcademicYear = AcademicYear()

    fun institution(institution: Institution) = apply { this.institution = institution }

    fun academicYear(academicYear: AcademicYear) = apply { this.academicYear = academicYear }

    override fun build(): Course{
        return withDefaultValues(Course(name, code, description, institution, academicYear))
    }
}