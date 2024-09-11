package app.com.eiduca.module.core.common.named

import app.com.eiduca.module.core.common.general.ConcreteModel
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class NamedDescriptionModel(
    @Column(unique = true) var name: String = "",
    @Column(unique = true) var description: String = "",
): ConcreteModel(), IUniqueAttributeModifier {

    constructor(): this("","")

    override fun updateUniqueAttributes() {
        val concat = nanoId()
        name += concat
        description += concat
    }

    override fun equals(other: Any?): Boolean {
        if (other !is NamedDescriptionModel) return false
        if (name != other.name) return false
        if (description != other.description) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + description.hashCode()
        return result
    }

    override fun setToString(fields: String): String = super.setToString("name='$name', $fields, description='$description'")
}