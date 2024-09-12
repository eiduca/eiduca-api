package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.DisciplineBuilder
import app.com.eiduca.module.academic.model.concrete.Discipline

class DisciplineFactory {
    companion object{
        fun build(name: String, code: String): Discipline = DisciplineBuilder()
            .name(name)
            .code(code)
            .description("Discipline of application")
            .build()
    }
}