package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.ConcreteRepository
import app.com.eiduca.module.core.model.concrect.Address
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository: ConcreteRepository<Address>{

}