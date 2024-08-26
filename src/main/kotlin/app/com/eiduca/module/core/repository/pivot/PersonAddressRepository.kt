package app.com.eiduca.module.core.repository.pivot

import app.com.eiduca.module.core.common.CommonRepository
import app.com.eiduca.module.core.model.pivot.PersonAddress
import org.springframework.stereotype.Repository

@Repository
interface PersonAddressRepository: CommonRepository<PersonAddress> {
}