package app.com.eiduca.module.candidacy.service

import app.com.eiduca.module.academic.common.datarange.DataRangeService
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.module.candidacy.repository.CalendarAccessExamRepository
import app.com.eiduca.module.core.exception.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CalendarAccessExamService(
    val calendarAccessExamRepository: CalendarAccessExamRepository
): DataRangeService<CalendarAccessExam>(calendarAccessExamRepository) {

    fun findByNumb(numb: Int): List<CalendarAccessExam> = calendarAccessExamRepository.findByNumb(numb)

    fun findByNumb(numb: Int, pageable: Pageable): Page<CalendarAccessExam> = calendarAccessExamRepository.findByNumb(numb, pageable)

    fun findByAcademicYear(academicYear: AcademicYear): List<CalendarAccessExam> = calendarAccessExamRepository.findByAcademicYear(academicYear)

    fun findByAcademicYear(academicYear: AcademicYear, pageable: Pageable): Page<CalendarAccessExam> = calendarAccessExamRepository.findByAcademicYear(academicYear, pageable)

    fun findByNumbAndAcademicYear(numb: Int, academicYear: AcademicYear): CalendarAccessExam{
        return calendarAccessExamRepository.findByNumbAndAcademicYear(numb, academicYear).orElseThrow { NotFoundException("Not found CalendarAccessExam by numb, academicYear") }
    }

    override fun findOrSave(obj: CalendarAccessExam): CalendarAccessExam {
        return calendarAccessExamRepository.findByNumbAndAcademicYear(obj.numb, obj.academicYear)
            .orElse(calendarAccessExamRepository.save(obj))
    }

    override fun saveOrUpdate(obj: CalendarAccessExam): CalendarAccessExam {
        calendarAccessExamRepository.findByNumbAndAcademicYear(obj.numb, obj.academicYear).ifPresent { obj.id = it.id }
        return calendarAccessExamRepository.save(obj)
    }

    override fun deleteIfExist(obj: CalendarAccessExam) {
        calendarAccessExamRepository.findByNumbAndAcademicYear(obj.numb, obj.academicYear).ifPresent { hidden(it) }
    }

    override fun destroyIfExist(obj: CalendarAccessExam) {
        calendarAccessExamRepository.findByNumbAndAcademicYear(obj.numb, obj.academicYear).ifPresent { destroy(it) }
    }
}