package app.com.eiduca.module.academic.repository.pivot

import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.model.pivot.InstitutionAddress
import app.com.eiduca.module.core.common.general.PivotRepository
import app.com.eiduca.module.core.model.concrect.Address
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface InstitutionAddressRepository: PivotRepository<InstitutionAddress>{
    fun findByInstitutionAndAddress(institution: Institution, address: Address): Optional<InstitutionAddress>
}