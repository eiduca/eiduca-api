package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionModel
import app.com.eiduca.module.academic.request.concrete.CourseRequest
import app.com.eiduca.module.core.interfaces.IConvertRequest
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
): CodeNamedDescriptionModel(code, name, description), IConvertRequest<Course> {

    constructor(): this("","",null, Institution(), AcademicYear())

    override fun toRequest(): CourseRequest = CourseRequest(code, name, description, institution.id, academicYear.id)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Course) return false
        if (!super.equals(other)) return false
        if (institution != other.institution) return false
        if (academicYear != other.academicYear) return false
        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + institution.hashCode()
        result = 31 * result + academicYear.hashCode()
        return result
    }

    override fun toString(): String {
        return "Course(${setToString("institution=$institution, academicYear=$academicYear")}"
    }
}