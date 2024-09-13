package app.com.eiduca.module.academic.repository.pivot

import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.core.common.general.PivotRepository
import app.com.eiduca.module.core.model.concrect.Address
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UniversityAddressRepository: PivotRepository<UniversityAddress>{
    fun findByUniversityAndAddress(university: University, address: Address): Optional<UniversityAddress>
}