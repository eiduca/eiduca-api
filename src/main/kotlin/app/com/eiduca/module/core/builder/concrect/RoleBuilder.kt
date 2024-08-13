package app.com.eiduca.module.core.builder.concrect

import app.com.eiduca.module.core.common.ConcreteBuilder
import app.com.eiduca.module.core.model.concrect.Role

class RoleBuilder: ConcreteBuilder<Role>(){
    private var name: String = ""
    private var description: String = ""
    fun name(name: String) = apply{ this.name = name }

    fun description(description: String) = apply{ this.description = description }

    override fun build(): Role {
        val role = Role(name, description)
        return withDefaultValues(role)
    }
}