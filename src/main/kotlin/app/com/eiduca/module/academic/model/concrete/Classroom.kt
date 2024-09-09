package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.core.common.general.ConcreteModel
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name ="tb_classrooms")
class Classroom(
    var code: String,
    @ManyToOne var course: Course,
    @ManyToOne var dayPeriod: DayPeriod,
    @ManyToOne var curriculumYear: CurriculumYear,
): ConcreteModel(){
    constructor(): this("", Course(), DayPeriod(), CurriculumYear())
}