package app.com.eiduca.module.candidacy.request.concrete

import app.com.eiduca.module.academic.builder.AcademicYearBuilder
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.candidacy.builder.CalendarAccessExamBuilder
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.core.interfaces.IConvertModel
import java.time.LocalDate

data class CalendarAccessExamRequest(
    var numb: Int,
    var academicYear: String,
    var startDate: LocalDate,
    var endDate: LocalDate,
): IConvertModel<CalendarAccessExam> {
    override fun toModel(): CalendarAccessExam = CalendarAccessExamBuilder()
        .academicYear(AcademicYearBuilder().id(academicYear).build())
        .numb(numb)
        .startDate(startDate)
        .endDate(endDate)
        .build()
}