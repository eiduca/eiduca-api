package app.com.eiduca.module.core.builder

import app.com.eiduca.module.core.common.ConcreteBuilder
import app.com.eiduca.module.core.model.concrect.Permission

class PermissionBuilder: ConcreteBuilder<Permission>(){
    private var name: String = ""
    private var description: String = ""
    private var entity: String = ""

    fun name(name: String) = apply{ this.name = name }

    fun description(description: String) = apply{ this.description = description }

    fun entity(entity: String) = apply{ this.entity = entity }

    override fun build(): Permission {
        val permission = Permission(name, description, entity)
        return withDefaultValues(permission)
    }

}