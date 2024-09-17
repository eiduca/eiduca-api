package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.dscipline.DisciplineRegimeProfileModel
import app.com.eiduca.module.academic.request.concrete.ClassroomDisciplineRequest
import app.com.eiduca.module.academic.request.concrete.CourseDisciplineRequest
import app.com.eiduca.module.core.interfaces.IConvertRequest
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_courser_disciplines")
class CourseDiscipline(
    @ManyToOne var course: Course,
    discipline: Discipline,
    regimeDiscipline: RegimeDiscipline,
    profileDiscipline: ProfileDiscipline
): DisciplineRegimeProfileModel(discipline, regimeDiscipline, profileDiscipline), IConvertRequest<CourseDiscipline> {
    constructor(): this(Course(), Discipline(), RegimeDiscipline(), ProfileDiscipline())

    override fun toRequest(): CourseDisciplineRequest {
        return CourseDisciplineRequest(course.id, discipline.id, regimeDiscipline.id, profileDiscipline.id)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CourseDiscipline) return false
        if (!super.equals(other)) return false
        if (course != other.course) return false
        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + course.hashCode()
        return result
    }

    override fun toString(): String = "CourseDiscipline(${setToString("course=$course")})"
}