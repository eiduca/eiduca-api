package app.com.eiduca.module.core.model.concrect

import app.com.eiduca.module.core.common.named.NamedDescriptionModel
import app.com.eiduca.module.core.interfaces.IConvertRequest
import app.com.eiduca.module.core.request.PermissionRequest
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_permissions")
class Permission(
    name:  String = "",
    description: String = "",
    var entity: String = "",
): NamedDescriptionModel(name, description), IConvertRequest<Permission> {

    constructor(): this("","","")

    override fun toString(): String = "Permission(${setToString("name='$name', description='$description', entity='$entity'")})"

    override fun toRequest(): PermissionRequest = PermissionRequest(name, description, entity)
}