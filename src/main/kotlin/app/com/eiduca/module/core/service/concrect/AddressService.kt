package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.ConcreteService
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.repository.concrect.AddressRepository
import org.springframework.stereotype.Service

@Service
class AddressService(
    val addressRepository: AddressRepository
): ConcreteService<Address>(addressRepository) {

}