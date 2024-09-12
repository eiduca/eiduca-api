package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.company.CompanyModel
import app.com.eiduca.module.academic.enums.InstitutionType
import app.com.eiduca.module.academic.request.concrete.InstitutionRequest
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name ="tb_institutions")
class Institution (
    name: String,
    acronym: String,
    email: String,
    contact: String,
    website: String,
    foundingDate: LocalDate,
    @ManyToOne var university: University,
    @Enumerated(EnumType.STRING) var type: InstitutionType = InstitutionType.FACULTY,
    latitude: Double? = null,
    longitude: Double? = null,
): CompanyModel(name, acronym, email, contact, website, foundingDate, latitude, longitude), IUniqueAttributeModifier {

    constructor(): this("","","","","",LocalDate.now(), University())

    override fun toString(): String = "Institution(${setToString("university=$university, type=$type")})"

    override fun equals(other: Any?): Boolean {
        if (other !is Institution) return false
        if (!super.equals(other)) return false
        return university == other.university
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + university.hashCode()
        return result
    }

    fun toInstitutionRequest(): InstitutionRequest = InstitutionRequest(university.id, name, acronym, email, contact, website, foundingDate, latitude, longitude)
}