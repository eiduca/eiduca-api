package app.com.eiduca.module.core.model.concrect

import app.com.eiduca.module.core.common.ConcreteModel
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_roles")
class Role (
    @Column(unique = true) var name: String,
    var description: String,
): ConcreteModel(), IUniqueAttributeModifier {

    override fun updateUniqueAttributes() {
        name += nanoId()
    }

    override fun toString(): String = "Role(${setToString("name='$name', description='$description'")})"
}