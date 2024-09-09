package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.company.CompanyService
import app.com.eiduca.module.academic.enums.InstitutionType
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.academic.repository.concrete.InstitutionRepository
import app.com.eiduca.module.core.exception.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class InstitutionService(
    val institutionRepository: InstitutionRepository
): CompanyService<Institution>(institutionRepository) {

    fun findByType(type: InstitutionType): List<Institution> = institutionRepository.findByType(type)

    fun findByType(type: InstitutionType, pageable: Pageable): Page<Institution> = institutionRepository.findByType(type, pageable)

    fun findByUniversity(university: University): List<Institution> = institutionRepository.findByUniversity(university)

    fun findByUniversity(university: University, pageable: Pageable): Page<Institution> = institutionRepository.findByUniversity(university, pageable)

    fun findByNameAndUniversity(name: String, university: University): Institution = institutionRepository.findByNameAndUniversity(name, university).orElseThrow { NotFoundException("Not found Institution by name and university")  }
}