package app.com.eiduca.module.academic.common.dscipline

import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline
import app.com.eiduca.module.core.common.general.ConcretePivotModel
import jakarta.persistence.ManyToOne
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class DisciplineRegimeProfileModel(
    @ManyToOne var discipline: Discipline,
    @ManyToOne var regimeDiscipline: RegimeDiscipline,
    @ManyToOne var profileDiscipline: ProfileDiscipline
): ConcretePivotModel() {

    override fun setToString(fields: String): String {
        return super.setToString("$fields, discipline=$discipline, regimeDiscipline=$regimeDiscipline, profileDiscipline=$profileDiscipline")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DisciplineRegimeProfileModel) return false
        if (!super.equals(other)) return false
        if (discipline != other.discipline) return false
        if (regimeDiscipline != other.regimeDiscipline) return false
        if (profileDiscipline != other.profileDiscipline) return false
        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + discipline.hashCode()
        result = 31 * result + regimeDiscipline.hashCode()
        result = 31 * result + profileDiscipline.hashCode()
        return result
    }
}