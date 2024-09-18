package app.com.eiduca.module.candidacy.builder

import app.com.eiduca.module.academic.common.datarange.DataRangeBuilder
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.candidacy.model.CalendarAccessExam

class CalendarAccessExamBuilder: DataRangeBuilder<CalendarAccessExam>() {
    private var numb: Int = 0
    private var academicYear: AcademicYear = AcademicYear()

    fun numb(numb: Int) = apply { this.numb = numb }

    fun academicYear(academicYear: AcademicYear) = apply { this.academicYear = academicYear }

    override fun build(): CalendarAccessExam {
        return withDefaultValues(CalendarAccessExam(numb, academicYear, startDate, endDate))
    }
}