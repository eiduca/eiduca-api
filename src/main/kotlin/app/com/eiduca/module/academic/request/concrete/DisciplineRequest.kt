package app.com.eiduca.module.academic.request.concrete

import app.com.eiduca.module.academic.builder.DisciplineBuilder
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.core.interfaces.IConvertModel

data class DisciplineRequest(
    var code: String,
    var name: String,
    var description: String?,
): IConvertModel<Discipline>{
    override fun toModel() : Discipline = DisciplineBuilder()
        .description(description)
        .name(name)
        .code(code)
        .build()
}