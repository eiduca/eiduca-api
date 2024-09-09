package app.com.eiduca.module.core.builder

import app.com.eiduca.module.core.common.named.NamedDescriptionBuilder
import app.com.eiduca.module.core.model.concrect.Role

class RoleBuilder: NamedDescriptionBuilder<Role>(){

    override fun build(): Role {
        val role = Role(name, description)
        return withDefaultValues(role)
    }
}