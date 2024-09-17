package app.com.eiduca.module.academic.common.dscipline

import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline
import app.com.eiduca.module.core.common.general.ConcreteBuilder

abstract class DisciplineRegimeProfileBuilder<T: DisciplineRegimeProfileModel>: ConcreteBuilder<T>() {

    protected var discipline: Discipline = Discipline()
    protected var regimeDiscipline: RegimeDiscipline = RegimeDiscipline()
    protected var profileDiscipline: ProfileDiscipline = ProfileDiscipline()

    fun discipline(discipline: Discipline) = apply { this.discipline = discipline }

    fun regimeDiscipline(regimeDiscipline: RegimeDiscipline) = apply { this.regimeDiscipline = regimeDiscipline }

    fun profileDiscipline(profileDiscipline: ProfileDiscipline) = apply { this.profileDiscipline = profileDiscipline }

    protected fun <T : DisciplineRegimeProfileModel> withDefaultValues(obj: T): T {
        obj.profileDiscipline = profileDiscipline
        obj.regimeDiscipline = regimeDiscipline
        obj.discipline = discipline
        return  super.withDefaultValues(obj)
    }
}