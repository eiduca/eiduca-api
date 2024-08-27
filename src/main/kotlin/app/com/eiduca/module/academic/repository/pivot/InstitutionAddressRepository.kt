package app.com.eiduca.module.academic.repository.pivot

import app.com.eiduca.module.academic.model.pivot.InstitutionAddress
import app.com.eiduca.module.core.common.CommonRepository
import org.springframework.stereotype.Repository

@Repository
interface InstitutionAddressRepository: CommonRepository<InstitutionAddress> {
}