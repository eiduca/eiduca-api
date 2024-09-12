package app.com.eiduca.module.academic.service.pivot

import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.academic.repository.pivot.UniversityAddressRepository
import app.com.eiduca.module.core.common.general.CommonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UniversityAddressService (
    val universityAddressRepository: UniversityAddressRepository
): CommonService<UniversityAddress>(universityAddressRepository){

    override fun saveOrUpdate(obj: UniversityAddress): UniversityAddress {
        return universityAddressRepository.findByUniversityAndAddress(obj.university, obj.address)
            .orElse(universityAddressRepository.save(obj))
    }

}