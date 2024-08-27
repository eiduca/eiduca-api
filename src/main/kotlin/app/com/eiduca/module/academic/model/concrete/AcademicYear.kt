package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.datarange.DataRangeModel
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name ="tb_academic_year")
class AcademicYear(
    @Column(unique = true) var name: String,
    @Column(unique = true) var code: String,
    startDate: LocalDate,
    endDate: LocalDate,
): DataRangeModel(startDate, endDate) {

    constructor(): this("","", LocalDate.now(), LocalDate.now())

    override fun toString(): String = "Institution(${setToString("name='$name', code='$code'")})"

    override fun equals(other: Any?): Boolean {
        if (other !is AcademicYear) return false
        if (name != other.name) return false
        if (code != other.code) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + code.hashCode()
        return result
    }

}