package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.datarange.DataRangeBuilder
import app.com.eiduca.module.academic.model.concrete.AcademicYear

class AcademicYearBuilder: DataRangeBuilder<AcademicYear>() {

    private var name: String = ""

    private var code: String = ""

    fun name(name: String) = apply{ this.name = name }

    fun code(code: String) = apply{ this.code = code }

    override fun build(): AcademicYear {
        val academicYear = AcademicYear(name,code, startDate, endDate)
        return withDefaultValues(academicYear)
    }

}