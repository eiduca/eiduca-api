package app.com.eiduca.module.core.service.pivot

import app.com.eiduca.module.core.common.general.CommonService
import app.com.eiduca.module.core.model.pivot.PersonAddress
import app.com.eiduca.module.core.repository.pivot.PersonAddressRepository
import org.springframework.stereotype.Service

@Service
class PersonAddressService(
    personAddressRepository: PersonAddressRepository
): CommonService<PersonAddress>(personAddressRepository)