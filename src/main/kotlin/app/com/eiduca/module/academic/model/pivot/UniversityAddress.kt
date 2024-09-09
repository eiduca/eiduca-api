package app.com.eiduca.module.academic.model.pivot

import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.core.common.general.PivotModel
import app.com.eiduca.module.core.model.concrect.Address
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_university_address")
class UniversityAddress (
    @ManyToOne var university: University,
    @ManyToOne var address: Address
): PivotModel() {
    constructor() : this(University(), Address())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UniversityAddress) return false
        if (university != other.university) return false
        if (address != other.address) return false
        return true
    }

    override fun hashCode(): Int {
        var result = university.hashCode()
        result = 31 * result + address.hashCode()
        return result
    }
}