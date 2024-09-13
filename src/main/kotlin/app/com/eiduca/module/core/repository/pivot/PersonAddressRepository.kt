package app.com.eiduca.module.core.repository.pivot

import app.com.eiduca.module.core.common.general.PivotRepository
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.model.pivot.PersonAddress
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PersonAddressRepository: PivotRepository<PersonAddress>{
    fun findByPersonAndAddress(person: Person, address: Address): Optional<PersonAddress>
}