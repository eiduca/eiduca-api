package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.company.CompanyService
import app.com.eiduca.module.academic.enums.InstitutionType
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.academic.repository.concrete.InstitutionRepository
import app.com.eiduca.module.core.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class InstitutionService(
    val institutionRepository: InstitutionRepository
): CompanyService<Institution>(institutionRepository) {

    fun findByType(type: InstitutionType): Institution = institutionRepository.findByType(type).orElseThrow { NotFoundException("Not found institution by type [$type]") }

    fun findByUniversity(university: University): Institution = institutionRepository.findByUniversity(university).orElseThrow { NotFoundException("Not found institution by university [$university]") }

}