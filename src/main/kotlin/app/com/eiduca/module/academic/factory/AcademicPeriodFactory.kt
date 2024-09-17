package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.AcademicPeriodBuilder
import app.com.eiduca.module.academic.model.concrete.AcademicPeriod

class AcademicPeriodFactory {
    companion object{
        fun build(numb: Int, name: String, code: String): AcademicPeriod = AcademicPeriodBuilder()
            .numb(numb)
            .name(name)
            .code(code)
            .description("AcademicPeriod of application")
            .build()
    }
}