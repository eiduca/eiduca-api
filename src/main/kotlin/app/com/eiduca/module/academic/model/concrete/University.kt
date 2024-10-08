package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.company.CompanyModel
import app.com.eiduca.module.academic.enums.UniversityType
import app.com.eiduca.module.academic.request.concrete.UniversityRequest
import app.com.eiduca.module.core.interfaces.IConvertRequest
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
    latitude: Double? = null,
    longitude: Double? = null,
): CompanyModel(name, acronym, email, contact, website, foundingDate, latitude, longitude), IConvertRequest<University> {

    constructor(): this("", "", "", "", "", LocalDate.now(), UniversityType.INDEFINITE)

    override fun toString(): String = "University(${setToString("type=$type")})"

    override fun equals(other: Any?): Boolean {
        if (other !is University) return false
        if (!super.equals(other)) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }

    override fun toRequest(): UniversityRequest = UniversityRequest(name, acronym, email, contact, website, foundingDate, type)
}