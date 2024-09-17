package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.CurriculumYearBuilder
import app.com.eiduca.module.academic.model.concrete.CurriculumYear

class CurriculumYearFactory {
    companion object{
        fun build(numb: Int, name: String, code: String): CurriculumYear = CurriculumYearBuilder()
            .numb(numb)
            .name(name)
            .code(code)
            .description("CurriculumYear of application")
            .build()
    }
}