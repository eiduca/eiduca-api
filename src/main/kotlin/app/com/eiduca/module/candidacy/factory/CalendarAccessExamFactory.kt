package app.com.eiduca.module.candidacy.factory

import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.candidacy.builder.CalendarAccessExamBuilder

class CalendarAccessExamFactory {
    companion object{
        fun build(numb: Int, academicYear: AcademicYear) = CalendarAccessExamBuilder()
            .academicYear(academicYear)
            .numb(numb)
            .startDate(academicYear.startDate)
            .endDate(academicYear.startDate.plusYears(30))
            .build()
    }
}