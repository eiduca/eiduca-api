package app.com.eiduca.module.candidacy.request.concrete

import app.com.eiduca.module.academic.builder.CourseBuilder
import app.com.eiduca.module.candidacy.builder.CalendarAccessExamBuilder
import app.com.eiduca.module.candidacy.builder.CandidateBuilder
import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.module.core.builder.PersonBuilder
import app.com.eiduca.module.core.interfaces.IConvertModel

data class CandidateRequest(
    var person: String,
    var course: String,
    var calendarAccessExam: String
): IConvertModel<Candidate> {
    override fun toModel(): Candidate = CandidateBuilder()
        .calendarAccessExam(CalendarAccessExamBuilder().id(calendarAccessExam).build())
        .course(CourseBuilder().id(course).build())
        .person(PersonBuilder().id(person).build())
        .build()
}