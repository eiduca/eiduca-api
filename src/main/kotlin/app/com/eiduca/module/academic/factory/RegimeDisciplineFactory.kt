package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.RegimeDisciplineBuilder
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline

class RegimeDisciplineFactory {
    companion object{
        fun build(name: String, code: String): RegimeDiscipline = RegimeDisciplineBuilder()
            .name(name)
            .code(code)
            .description("Regime discipline of application")
            .build()
    }
}