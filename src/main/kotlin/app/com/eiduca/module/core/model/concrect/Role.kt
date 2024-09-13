package app.com.eiduca.module.core.model.concrect

import app.com.eiduca.module.core.common.general.CommonModel
import app.com.eiduca.module.core.common.named.NamedDescriptionModel
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.interfaces.IConvertRequest
import app.com.eiduca.module.core.request.RoleRequest
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_roles")
class Role (
    name: String,
    description: String,
): NamedDescriptionModel(name, description), IConvertRequest<Role> {

    constructor(): this("","")

    override fun toString(): String = "Role(${setToString("name='$name', description='$description'")})"

    override fun toRequest(): RoleRequest = RoleRequest(name, description)
}