package app.com.eiduca.module.core.model.concrect

import app.com.eiduca.module.core.common.ConcreteModel
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import app.com.eiduca.module.core.request.body.PermissionRequest
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_permissions")
class Permission(
    @Column(unique = true) var name: String,
    var description: String,
    var entity: String,
): ConcreteModel(), IUniqueAttributeModifier {

    constructor(): this("","","")

    override fun updateUniqueAttributes() {
        name += nanoId()
    }

    override fun toString(): String = "Permission(${setToString("name='$name', description='$description', entity='$entity'")})"

    override fun equals(other: Any?): Boolean = if(other is Permission) name == other.name else false

    override fun hashCode(): Int = name.hashCode()

    fun toPermissionRequest(): PermissionRequest = PermissionRequest(name, description, entity)

}