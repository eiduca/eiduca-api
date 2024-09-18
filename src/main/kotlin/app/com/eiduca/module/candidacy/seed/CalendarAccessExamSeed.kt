package app.com.eiduca.module.candidacy.seed

import app.com.eiduca.module.academic.seed.AcademicYearSeed
import app.com.eiduca.module.candidacy.factory.CalendarAccessExamFactory
import app.com.eiduca.module.candidacy.model.CalendarAccessExam

enum class CalendarAccessExamSeed(
    var calendarAccessExam: CalendarAccessExam
) {
    FASE_ONE_23_24(CalendarAccessExamFactory.build(1, AcademicYearSeed.YEAR_23_24.academicYear))
}