package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.DataRangeService
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.academic.repository.concrete.AcademicYearRepository
import app.com.eiduca.module.core.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class AcademicYearService(
    val academicYearRepository: AcademicYearRepository
): DataRangeService<AcademicYear>(academicYearRepository) {

    fun findByName(name: String): AcademicYear = academicYearRepository.findByName(name).orElseThrow { NotFoundException("Not found academicYear by name [$name]") }

    fun findByCode(code: String): AcademicYear = academicYearRepository.findByCode(code).orElseThrow { NotFoundException("Not found academicYear by code [$code]") }

}