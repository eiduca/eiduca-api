package app.com.eiduca.module.core.factory.concrete

import app.com.eiduca.module.core.builder.concrect.PermissionBuilder
import app.com.eiduca.module.core.enums.EntityEnum
import app.com.eiduca.module.core.enums.RegisterType
import app.com.eiduca.module.core.model.concrect.Permission

class PermissionFactory {

    companion object{

        fun build(name: String, description: String, entity: EntityEnum = EntityEnum.NONE) : Permission = PermissionBuilder()
            .name("PERMISSION_$name")
            .description(description)
            .entity(entity.name)
            .registerType(RegisterType.SYSTEM)
            .build()

    }

}