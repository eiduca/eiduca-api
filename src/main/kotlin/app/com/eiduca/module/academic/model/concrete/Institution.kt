package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.CompanyModel
import app.com.eiduca.module.academic.enums.InstitutionType
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name ="tb_institution")
class Institution (
    @ManyToOne var university: University,
    @Enumerated(EnumType.STRING) var type: InstitutionType = InstitutionType.FACULTY,
    name: String,
    acronym: String,
    email: String,
    contact: String,
    website: String,
    foundingDate: LocalDate,
): CompanyModel(name, acronym, email, contact, website, foundingDate), IUniqueAttributeModifier {

}