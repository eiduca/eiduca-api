package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.dscipline.DisciplineRegimeProfileModel
import app.com.eiduca.module.academic.request.concrete.ClassroomDisciplineRequest
import app.com.eiduca.module.core.common.general.PivotModel
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.interfaces.IConvertRequest
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_classroom_disciplines")
class ClassroomDiscipline(
    @ManyToOne var classroom: Classroom,
    discipline: Discipline,
    regimeDiscipline: RegimeDiscipline,
    profileDiscipline: ProfileDiscipline
): DisciplineRegimeProfileModel(discipline, regimeDiscipline, profileDiscipline), IConvertRequest<ClassroomDiscipline> {
    constructor(): this(Classroom(), Discipline(), RegimeDiscipline(), ProfileDiscipline())

    override fun toRequest(): ClassroomDisciplineRequest {
        return ClassroomDisciplineRequest(classroom.id, discipline.id, regimeDiscipline.id, profileDiscipline.id)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ClassroomDiscipline) return false
        if (!super.equals(other)) return false
        if (classroom != other.classroom) return false
        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + classroom.hashCode()
        return result
    }

    override fun toString(): String = "ClassroomDiscipline(${setToString("classroom=$classroom")})"
}