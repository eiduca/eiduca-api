package app.com.eiduca.module.academic.request.concrete

import app.com.eiduca.module.academic.builder.DayPeriodBuilder
import app.com.eiduca.module.academic.model.concrete.DayPeriod
import app.com.eiduca.module.core.interfaces.IConvertModel

data class DayPeriodRequest(
    var code: String,
    var name: String,
    var description: String?,
): IConvertModel<DayPeriod>{
    override fun toModel() : DayPeriod = DayPeriodBuilder()
        .description(description)
        .name(name)
        .code(code)
        .build()
}