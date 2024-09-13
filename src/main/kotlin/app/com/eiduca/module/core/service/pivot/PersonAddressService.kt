package app.com.eiduca.module.core.service.pivot

import app.com.eiduca.module.core.common.general.PivotService
import app.com.eiduca.module.core.model.pivot.PersonAddress
import app.com.eiduca.module.core.repository.pivot.PersonAddressRepository
import org.springframework.stereotype.Service

@Service
class PersonAddressService(
    val personAddressRepository: PersonAddressRepository
): PivotService<PersonAddress>(personAddressRepository){

    override fun findOrSave(obj: PersonAddress): PersonAddress {
       return personAddressRepository.findByPersonAndAddress(obj.person, obj.address).orElse(personAddressRepository.save(obj))
    }

    override fun deleteIfExist(obj: PersonAddress) {
        personAddressRepository.findByPersonAndAddress(obj.person, obj.address).ifPresent { delete(it) }
    }
}