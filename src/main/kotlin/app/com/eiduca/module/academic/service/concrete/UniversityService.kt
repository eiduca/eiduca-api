package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.company.CompanyService
import app.com.eiduca.module.academic.enums.UniversityType
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.academic.repository.concrete.UniversityRepository
import app.com.eiduca.module.core.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class UniversityService(
    val universityRepository: UniversityRepository
): CompanyService<University>(universityRepository) {

    fun findByType(type: UniversityType): University = universityRepository.findByType(type).orElseThrow { NotFoundException("Not found university by type [$type]") }

}