package app.com.eiduca.module.candidacy.model

import app.com.eiduca.module.academic.common.datarange.DataRangeModel
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name ="tb_calendar_access_exam")
class CalendarAccessExam(
    var numb: Int,
    @ManyToOne var academicYear: AcademicYear,
    startDate: LocalDate,
    endDate: LocalDate,
): DataRangeModel(startDate, endDate) {

    constructor(): this(0, AcademicYear(), LocalDate.now(), LocalDate.now())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CalendarAccessExam) return false
        if (!super.equals(other)) return false
        if (numb != other.numb) return false
        if (academicYear != other.academicYear) return false
        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + numb
        result = 31 * result + academicYear.hashCode()
        return result
    }

    override fun toString(): String {
        return "CalendarAccessExam(${super.setToString("numb=$numb, academicYear=$academicYear")})"
    }
}