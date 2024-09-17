package app.com.eiduca.module.academic.request.concrete

import app.com.eiduca.module.academic.builder.ProfileDisciplineBuilder
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline
import app.com.eiduca.module.core.interfaces.IConvertModel

data class ProfileDisciplineRequest(
    var code: String,
    var name: String,
    var description: String?,
): IConvertModel<ProfileDiscipline>{
    override fun toModel() : ProfileDiscipline = ProfileDisciplineBuilder()
        .description(description)
        .name(name)
        .code(code)
        .build()
}