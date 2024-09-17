package app.com.eiduca.module.academic.common.order

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionModel
import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class OrderCodeNamedDescriptionModel(
    @Column(unique = true) var numb: Int,
    code: String,
    name: String,
    description: String?,
): CodeNamedDescriptionModel(code, name, description){

    constructor(): this(0,"","", "")

    override fun updateUniqueAttributes() {
        super.updateUniqueAttributes()
        numb += 1000
    }

    override fun setToString(fields: String): String {
        return super.setToString("numb='$numb', $fields")
    }

    override fun toString(): String = super.setToString("numb='$numb'")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is OrderCodeNamedDescriptionModel) return false
        if (!super.equals(other)) return false
        if (numb != other.numb) return false
        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + numb
        return result
    }
}
