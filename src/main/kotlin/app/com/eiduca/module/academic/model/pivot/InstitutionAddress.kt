package app.com.eiduca.module.academic.model.pivot

import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.request.pivot.InstitutionAddressRequest
import app.com.eiduca.module.core.common.general.PivotModel
import app.com.eiduca.module.core.model.concrect.Address
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_institution_address")
class InstitutionAddress (
    @ManyToOne var institution: Institution,
    @ManyToOne var address: Address
): PivotModel() {

    constructor() : this(Institution(), Address())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is InstitutionAddress) return false
        if (institution != other.institution) return false
        if (address != other.address) return false
        return true
    }

    override fun hashCode(): Int {
        var result = institution.hashCode()
        result = 31 * result + address.hashCode()
        return result
    }

    fun toInstitutionAddressRequest(): InstitutionAddressRequest = InstitutionAddressRequest(institution.id, address.id)
}