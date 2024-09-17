package app.com.eiduca.module.academic.request.concrete

import app.com.eiduca.module.academic.builder.RegimeDisciplineBuilder
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline
import app.com.eiduca.module.core.interfaces.IConvertModel

data class RegimeDisciplineRequest(
    var code: String,
    var name: String,
    var description: String?,
): IConvertModel<RegimeDiscipline>{
    override fun toModel() : RegimeDiscipline = RegimeDisciplineBuilder()
        .description(description)
        .name(name)
        .code(code)
        .build()
}