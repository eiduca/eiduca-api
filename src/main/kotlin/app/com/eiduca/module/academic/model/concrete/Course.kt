package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionModel
import app.com.eiduca.module.academic.request.concrete.CourseRequest
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name ="tb_courses")
class Course(
    code: String,
    name: String,
    description: String?,
    @ManyToOne var institution: Institution,
    @ManyToOne var academicYear: AcademicYear,
): CodeNamedDescriptionModel(code, name, description) {

    constructor(): this("","",null, Institution(), AcademicYear())

    fun toCourseRequest(): CourseRequest = CourseRequest(code, name, description, institution.id, academicYear.id)
}