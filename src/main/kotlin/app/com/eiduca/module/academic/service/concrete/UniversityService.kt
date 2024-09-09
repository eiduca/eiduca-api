package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.company.CompanyService
import app.com.eiduca.module.academic.enums.UniversityType
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.academic.repository.concrete.UniversityRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UniversityService(
    val universityRepository: UniversityRepository
): CompanyService<University>(universityRepository) {

    fun findByType(type: UniversityType): List<University> = universityRepository.findByType(type)

    fun findByType(type: UniversityType, pageable: Pageable): Page<University> = universityRepository.findByType(type, pageable)

}