package app.com.eiduca.module.academic.common.named

import app.com.eiduca.module.core.common.general.ConcreteModel
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class CodeNamedDescriptionModel(
    @Column(unique = true) var code: String,
    var name: String,
    @Column(nullable = true) var description: String?,
): ConcreteModel(), IUniqueAttributeModifier {

    constructor(): this("","",null)

    override fun updateUniqueAttributes() {
        code +=  nanoId()
    }

    override fun equals(other: Any?): Boolean {
        return other is CodeNamedDescriptionModel && code == other.code
    }

    override fun hashCode(): Int = code.hashCode()

    override fun setToString(fields: String): String {
        return super.setToString("code='$code', name='$name', description=$description")
    }
}
