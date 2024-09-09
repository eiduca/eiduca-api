package app.com.eiduca.module.academic.common.company

import app.com.eiduca.module.core.common.general.ConcreteModel
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import java.time.LocalDate

@MappedSuperclass
abstract class CompanyModel(
    @Column(unique = true) var name: String,
    @Column(unique = true) var acronym: String,
    @Column(nullable = true) var email: String,
    @Column(nullable = true) var contact: String,
    @Column(nullable = true) var website: String,
    var foundingDate: LocalDate,
    @Column(nullable = true)
    var latitude: Double? = null,
    @Column(nullable = true)
    var longitude: Double? = null,
): ConcreteModel(), IUniqueAttributeModifier {

    constructor(): this("","","","","",LocalDate.now())

    override fun updateUniqueAttributes() {
        val concat = nanoId()
        name += concat
        acronym += concat
    }

    override fun setToString(fields: String): String = super.setToString("name='$name', acronym='$acronym', email='$email', contact='$contact', website='$website', foundingDate=$foundingDate, $fields")

    override fun equals(other: Any?): Boolean {
        if (other !is CompanyModel) return false
        if (name != other.name) return false
        if (acronym != other.acronym) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + acronym.hashCode()
        return result
    }

}