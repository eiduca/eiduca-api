package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.datarange.DataRangeModel
import app.com.eiduca.module.academic.request.concrete.AcademicYearRequest
import app.com.eiduca.module.core.interfaces.IConvertRequest
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name ="tb_academic_years")
class AcademicYear(
    @Column(unique = true) var name: String,
    @Column(unique = true) var code: String,
    startDate: LocalDate,
    endDate: LocalDate,
): DataRangeModel(startDate, endDate), IUniqueAttributeModifier, IConvertRequest<AcademicYear> {

    constructor(): this("","", LocalDate.now(), LocalDate.now())

    override fun updateUniqueAttributes() {
        val concat = nanoId()
        name += concat
        code += concat
    }

    override fun toString(): String = "AcademicYear(${setToString("name='$name', code='$code'")})"

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

    override fun toRequest(): AcademicYearRequest = AcademicYearRequest(name, code, startDate, endDate)
}