package app.com.eiduca.module.candidacy.request.concrete

import app.com.eiduca.module.academic.builder.CourseBuilder
import app.com.eiduca.module.academic.builder.DisciplineBuilder
import app.com.eiduca.module.candidacy.builder.AccessExamBuilder
import app.com.eiduca.module.candidacy.builder.CalendarAccessExamBuilder
import app.com.eiduca.module.candidacy.model.AccessExam
import app.com.eiduca.module.core.interfaces.IConvertModel
import java.time.LocalDateTime

data class AccessExamRequest(
    var course: String,
    var discipline: String,
    var calendarAccessExam: String,
    var startDateTime: LocalDateTime,
    var endDateTime: LocalDateTime,
): IConvertModel<AccessExam> {
    override fun toModel(): AccessExam = AccessExamBuilder()
        .calendarAccessExam(CalendarAccessExamBuilder().id(calendarAccessExam).build())
        .discipline(DisciplineBuilder().id(discipline).build())
        .course(CourseBuilder().id(course).build())
        .startDateTime(startDateTime)
        .endDateTime(endDateTime)
        .build()
}