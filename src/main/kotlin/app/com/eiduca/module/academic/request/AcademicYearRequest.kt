package app.com.eiduca.module.academic.request

import app.com.eiduca.module.academic.builder.AcademicYearBuilder
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.core.interfaces.IConvertModel
import java.time.LocalDate

data class AcademicYearRequest(
    val name: String,
    val code: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
): IConvertModel<AcademicYear>{

    override fun toModel() : AcademicYear = AcademicYearBuilder()
        .name(name)
        .code(code)
        .startDate(startDate)
        .endDate(endDate)
        .build()

}