package app.com.eiduca.module.core.model.concrect

import app.com.eiduca.module.core.common.ConcreteModel
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import app.com.eiduca.module.core.request.body.RoleRequest
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_roles")
class Role (
    @Column(unique = true) var name: String,
    var description: String,
): ConcreteModel(), IUniqueAttributeModifier {

    constructor(): this("","")

    override fun updateUniqueAttributes() {
        name += nanoId()
    }

    override fun toString(): String = "Role(${setToString("name='$name', description='$description'")})"

    override fun equals(other: Any?): Boolean = if(other is Role) name == other.name else false

    override fun hashCode(): Int = name.hashCode()

    fun toRoleRequest(): RoleRequest = RoleRequest(name, description)

}