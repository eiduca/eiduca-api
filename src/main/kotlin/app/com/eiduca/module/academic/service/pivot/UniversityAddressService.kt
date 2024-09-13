package app.com.eiduca.module.academic.service.pivot

import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.academic.repository.pivot.UniversityAddressRepository
import app.com.eiduca.module.core.common.general.PivotService
import org.springframework.stereotype.Service

@Service
class UniversityAddressService (
    val universityAddressRepository: UniversityAddressRepository
): PivotService<UniversityAddress>(universityAddressRepository){
    override fun findOrSave(obj: UniversityAddress): UniversityAddress {
        return universityAddressRepository.findByUniversityAndAddress(obj.university, obj.address).orElse(universityAddressRepository.save(obj))
    }

    override fun deleteIfExist(obj: UniversityAddress) {
        universityAddressRepository.findByUniversityAndAddress(obj.university, obj.address).ifPresent { delete(it) }
    }
}