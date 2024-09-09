package app.com.eiduca.module.core.builder

import app.com.eiduca.module.core.common.named.NamedDescriptionBuilder
import app.com.eiduca.module.core.model.concrect.Permission

class PermissionBuilder: NamedDescriptionBuilder<Permission>(){
    private var entity: String = ""

    fun entity(entity: String) = apply{ this.entity = entity }

    override fun build(): Permission {
        val permission = Permission(name, description, entity)
        return withDefaultValues(permission)
    }
}