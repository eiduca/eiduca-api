package app.com.eiduca.module.academic.service.pivot

import app.com.eiduca.module.academic.model.pivot.InstitutionAddress
import app.com.eiduca.module.academic.repository.pivot.InstitutionAddressRepository
import app.com.eiduca.module.core.common.general.PivotService
import org.springframework.stereotype.Service

@Service
class InstitutionAddressService (
    val institutionAddressRepository: InstitutionAddressRepository
): PivotService<InstitutionAddress>(institutionAddressRepository){
    override fun findOrSave(obj: InstitutionAddress): InstitutionAddress {
        return institutionAddressRepository.findByInstitutionAndAddress(obj.institution, obj.address).orElse(institutionAddressRepository.save(obj))
    }

    override fun deleteIfExist(obj: InstitutionAddress) {
        institutionAddressRepository.findByInstitutionAndAddress(obj.institution, obj.address).ifPresent { delete(it) }
    }
}