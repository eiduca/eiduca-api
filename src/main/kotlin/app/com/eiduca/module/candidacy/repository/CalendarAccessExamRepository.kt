package app.com.eiduca.module.candidacy.repository

import app.com.eiduca.module.academic.common.datarange.DataRangeRepository
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.candidacy.query.CalendarAccessExamJPQL
import app.com.eiduca.module.core.query.EntityJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CalendarAccessExamRepository: DataRangeRepository<CalendarAccessExam> {
    @Query(name = "ModelConcrete.findByNumb")
    fun findByNumb(numb: Int): List<CalendarAccessExam>

    @Query(name = "ModelConcrete.findByNumb", countName = "ModelConcrete.findByNumbCount")
    fun findByNumb(numb: Int, pageable: Pageable): Page<CalendarAccessExam>

    @Query(name = EntityJPQL.FIND_ALL_ACADEMIC_YEAR)
    fun findByAcademicYear(academicYear: AcademicYear): List<CalendarAccessExam>

    @Query(name = EntityJPQL.FIND_ALL_ACADEMIC_YEAR, countName = EntityJPQL.FIND_COUNT_ACADEMIC_YEAR)
    fun findByAcademicYear(academicYear: AcademicYear, pageable: Pageable): Page<CalendarAccessExam>

    @Query(name = CalendarAccessExamJPQL.FIND_BY_CALENDAR_ACCESS_EXAM)
    fun findByNumbAndAcademicYear(numb: Int, academicYear: AcademicYear): Optional<CalendarAccessExam>
}