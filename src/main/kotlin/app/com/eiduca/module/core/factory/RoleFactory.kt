package app.com.eiduca.module.core.factory

import app.com.eiduca.module.core.builder.RoleBuilder
import app.com.eiduca.module.core.enums.RegisterType
import app.com.eiduca.module.core.model.concrect.Role

class RoleFactory {

    companion object{

        fun build(name: String, description: String) : Role = RoleBuilder()
            .name("ROLE_$name")
            .description(description)
            .registerType(RegisterType.SYSTEM)
            .build()

    }
}