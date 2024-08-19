package app.com.eiduca.module.core.factory

import app.com.eiduca.module.core.builder.concrect.RoleBuilder
import app.com.eiduca.module.core.enums.RegisterType
import app.com.eiduca.module.core.model.concrect.Role

class RoleFactory {
    companion object{

        fun build(name: String, description: String, registerType: RegisterType = RegisterType.APPLICATION) : Role = RoleBuilder()
            .name("ROLE_$name")
            .description(description)
            .registerType(registerType)
            .build()

    }
}