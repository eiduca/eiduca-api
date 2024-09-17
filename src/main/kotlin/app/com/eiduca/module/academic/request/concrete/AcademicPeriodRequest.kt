package app.com.eiduca.module.academic.request.concrete

import app.com.eiduca.module.academic.builder.AcademicPeriodBuilder
import app.com.eiduca.module.academic.model.concrete.AcademicPeriod
import app.com.eiduca.module.core.interfaces.IConvertModel

data class AcademicPeriodRequest (
    var numb: Int,
    var code: String,
    var name: String,
    var description: String?
): IConvertModel<AcademicPeriod>{
    override fun toModel(): AcademicPeriod = AcademicPeriodBuilder()
        .numb(numb)
        .description(description)
        .code(code)
        .name(name)
        .build()
}