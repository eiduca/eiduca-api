package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionService
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.repository.concrete.CourseRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CourseService(
    val courseRepository: CourseRepository
): CodeNamedDescriptionService<Course>(courseRepository){

    fun findByInstitution(institution: Institution): List<Course> = courseRepository.findByInstitution(institution)

    fun findByInstitution(institution: Institution, pageable: Pageable): Page<Course> = courseRepository.findByInstitution(institution, pageable)

    fun findByAcademicYear(academicYear: AcademicYear): List<Course> = courseRepository.findByAcademicYear(academicYear)

    fun findByAcademicYear(academicYear: AcademicYear, pageable: Pageable): Page<Course> = courseRepository.findByAcademicYear(academicYear, pageable)
}