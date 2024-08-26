package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.CompanyModel
import app.com.eiduca.module.academic.enums.UniversityType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name ="tb_university")
class University(
    name: String,
    acronym: String,
    email: String,
    contact: String,
    website: String,
    foundingDate: LocalDate,
    @Enumerated(EnumType.STRING) var type: UniversityType = UniversityType.INDEFINITE,
): CompanyModel(name, acronym, email, contact, website, foundingDate) {

}