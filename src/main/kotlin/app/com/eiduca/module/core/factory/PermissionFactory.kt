package app.com.eiduca.module.core.factory

import app.com.eiduca.module.core.builder.PermissionBuilder
import app.com.eiduca.module.core.enums.EntityEnum
import app.com.eiduca.module.core.enums.RegisterType
import app.com.eiduca.module.core.model.concrect.Permission

class PermissionFactory {

    companion object{

        fun build(name: String, description: String, entity: EntityEnum = EntityEnum.NONE) : Permission = PermissionBuilder()
            .entity(entity.name)
            .name("PERMISSION_$name")
            .description(description)
            .registerType(RegisterType.SYSTEM)
            .build()

    }

}