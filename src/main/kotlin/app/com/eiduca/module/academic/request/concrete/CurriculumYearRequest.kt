package app.com.eiduca.module.academic.request.concrete

import app.com.eiduca.module.academic.builder.CurriculumYearBuilder
import app.com.eiduca.module.academic.model.concrete.CurriculumYear
import app.com.eiduca.module.core.interfaces.IConvertModel

data class CurriculumYearRequest(
    var numb: Int,
    var code: String,
    var name: String,
    var description: String?,
): IConvertModel<CurriculumYear>{
    override fun toModel() : CurriculumYear = CurriculumYearBuilder()
        .numb(numb)
        .description(description)
        .name(name)
        .code(code)
        .build()
}