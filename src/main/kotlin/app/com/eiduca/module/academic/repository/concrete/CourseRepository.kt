package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionRepository
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.query.CourseJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository: CodeNamedDescriptionRepository<Course> {

    @Query(name = CourseJPQL.FIND_ALL_INSTITUTION)
    fun findByInstitution(institution: Institution): List<Course>

    @Query(name = CourseJPQL.FIND_ALL_INSTITUTION, countName = CourseJPQL.FIND_COUNT_INSTITUTION)
    fun findByInstitution(institution: Institution, pageable: Pageable): Page<Course>

    @Query(name = CourseJPQL.FIND_ALL_ACADEMIC_YEAR)
    fun findByAcademicYear(academicYear: AcademicYear): List<Course>

    @Query(name = CourseJPQL.FIND_ALL_ACADEMIC_YEAR, countName = CourseJPQL.FIND_COUNT_ACADEMIC_YEAR)
    fun findByAcademicYear(academicYear: AcademicYear, pageable: Pageable): Page<Course>
}