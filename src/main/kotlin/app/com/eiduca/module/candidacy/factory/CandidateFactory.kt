package app.com.eiduca.module.candidacy.factory

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.candidacy.builder.CandidateBuilder
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.module.core.model.concrect.Person

class CandidateFactory {
    companion object{
        fun build(person: Person, course: Course, calendarAccessExam: CalendarAccessExam): Candidate = CandidateBuilder()
            .person(person)
            .course(course)
            .calendarAccessExam(calendarAccessExam)
            .build()
    }
}