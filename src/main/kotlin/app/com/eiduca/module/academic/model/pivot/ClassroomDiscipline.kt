package app.com.eiduca.module.academic.model.pivot

import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.core.common.general.PivotModel
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_classroom_discipline")
class ClassroomDiscipline(
    @ManyToOne var classroom: Classroom,
    @ManyToOne var discipline: Discipline
): PivotModel() {

    constructor(): this(Classroom(), Discipline())

}