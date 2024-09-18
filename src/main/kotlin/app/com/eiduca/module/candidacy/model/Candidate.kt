package app.com.eiduca.module.candidacy.model

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.core.common.general.ConcreteModel
import app.com.eiduca.module.core.model.concrect.Person
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name ="tb_candidates")
class Candidate(
    @ManyToOne var person: Person,
    @ManyToOne var course: Course,
    @ManyToOne var calendarAccessExam: CalendarAccessExam
): ConcreteModel() {

    constructor(): this(Person(), Course(), CalendarAccessExam())

}