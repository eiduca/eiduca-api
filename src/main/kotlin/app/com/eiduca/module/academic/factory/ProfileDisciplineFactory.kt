package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.ProfileDisciplineBuilder
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline

class ProfileDisciplineFactory {
    companion object{
        fun build(name: String, code: String): ProfileDiscipline = ProfileDisciplineBuilder()
            .name(name)
            .code(code)
            .description("Profile discipline of application")
            .build()
    }
}