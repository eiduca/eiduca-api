package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.model.concrete.*
import app.com.eiduca.module.academic.repository.concrete.ClassroomRepository
import app.com.eiduca.module.core.common.general.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ClassroomService(
    val classroomRepository: ClassroomRepository
): ConcreteService<Classroom>(classroomRepository){

    fun findByCode(code: String): Classroom = classroomRepository.findByCode(code).orElseThrow { NotFoundException("Not found Classroom by code") }

    fun findByCourse(course: Course): List<Classroom> = classroomRepository.findByCourse(course)

    fun findByCourse(course: Course, pageable: Pageable): Page<Classroom> = classroomRepository.findByCourse(course, pageable)

    fun findByDayPeriod(dayPeriod: DayPeriod): List<Classroom> = classroomRepository.findByDayPeriod(dayPeriod)

    fun findByDayPeriod(dayPeriod: DayPeriod, pageable: Pageable): Page<Classroom> = classroomRepository.findByDayPeriod(dayPeriod, pageable)

    fun findByCurriculumYear(curriculumYear: CurriculumYear): List<Classroom> = classroomRepository.findByCurriculumYear(curriculumYear)

    fun findByCurriculumYear(curriculumYear: CurriculumYear, pageable: Pageable): Page<Classroom> = classroomRepository.findByCurriculumYear(curriculumYear, pageable)

    fun findByAcademicPeriod(academicPeriod: AcademicPeriod): List<Classroom> = classroomRepository.findByAcademicPeriod(academicPeriod)

    fun findByAcademicPeriod(academicPeriod: AcademicPeriod, pageable: Pageable): Page<Classroom> = classroomRepository.findByAcademicPeriod(academicPeriod, pageable)

    fun findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear(course: Course, dayPeriod: DayPeriod, academicPeriod: AcademicPeriod, curriculumYear: CurriculumYear): Classroom {
        return classroomRepository.findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear(course, dayPeriod, academicPeriod, curriculumYear)
            .orElseThrow { NotFoundException("Not found Classroom by course, dayPeriod, academicPeriod, curriculumYear") }
    }

    override fun findOrSave(obj: Classroom): Classroom {
        return classroomRepository.findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear(obj.course, obj.dayPeriod, obj.academicPeriod, obj.curriculumYear)
            .orElse(classroomRepository.save(obj))
    }

    override fun saveOrUpdate(obj: Classroom): Classroom {
        classroomRepository.findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear(obj.course, obj.dayPeriod, obj.academicPeriod, obj.curriculumYear).ifPresent { obj.id = it.id }
        return classroomRepository.save(obj)
    }

    override fun deleteIfExist(obj: Classroom) {
        classroomRepository.findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear(obj.course, obj.dayPeriod, obj.academicPeriod, obj.curriculumYear).ifPresent { hidden(it) }
    }

    override fun destroyIfExist(obj: Classroom) {
        classroomRepository.findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear(obj.course, obj.dayPeriod, obj.academicPeriod, obj.curriculumYear).ifPresent { destroy(it) }
    }
}