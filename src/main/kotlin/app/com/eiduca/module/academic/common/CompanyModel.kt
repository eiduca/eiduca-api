package app.com.eiduca.module.academic.common

import app.com.eiduca.module.core.common.ConcreteModel
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
):ConcreteModel(), IUniqueAttributeModifier {

    override fun updateUniqueAttributes() {
        val concat = nanoId()
        name += concat
        acronym += concat
    }

}