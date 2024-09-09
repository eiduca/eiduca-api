package app.com.eiduca.module.core.model.pivot

import app.com.eiduca.module.core.common.general.PivotModel
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.request.PersonAddressRequest
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_person_address")
class PersonAddress(
    @ManyToOne var person: Person,
    @ManyToOne var address: Address
): PivotModel(){

    constructor(): this(Person(), Address())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PersonAddress

        if (person != other.person) return false
        if (address != other.address) return false

        return true
    }

    override fun hashCode(): Int {
        var result = person.hashCode()
        result = 31 * result + address.hashCode()
        return result
    }

    fun toPersonAddressRequest(): PersonAddressRequest = PersonAddressRequest(person.id, address.id)

}