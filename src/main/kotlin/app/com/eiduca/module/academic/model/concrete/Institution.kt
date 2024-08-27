package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.company.CompanyModel
import app.com.eiduca.module.academic.enums.InstitutionType
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name ="tb_institution")
class Institution (
    name: String,
    acronym: String,
    email: String,
    contact: String,
    website: String,
    foundingDate: LocalDate,
    @ManyToOne var university: University,
    @Enumerated(EnumType.STRING) var type: InstitutionType = InstitutionType.FACULTY,
): CompanyModel(name, acronym, email, contact, website, foundingDate), IUniqueAttributeModifier {

    constructor(): this("","","","","",LocalDate.now(), University())

    override fun toString(): String = "Institution(${setToString("university=$university, type=$type")})"

}