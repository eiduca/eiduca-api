package app.com.eiduca.module.candidacy.builder

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.module.core.common.general.ConcreteBuilder
import app.com.eiduca.module.core.model.concrect.Person

class CandidateBuilder: ConcreteBuilder<Candidate>() {

    private var person: Person = Person()
    private var course: Course = Course()
    private var calendarAccessExam: CalendarAccessExam = CalendarAccessExam()

    fun person(person: Person) = apply { this.person = person }

    fun course(course: Course) = apply { this.course = course }

    fun calendarAccessExam(calendarAccessExam: CalendarAccessExam) = apply { this.calendarAccessExam = calendarAccessExam }

    override fun build(): Candidate {
        return withDefaultValues(Candidate(person, course, calendarAccessExam))
    }
}