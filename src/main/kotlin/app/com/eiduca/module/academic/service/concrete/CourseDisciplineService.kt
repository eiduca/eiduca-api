package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.dscipline.DisciplineRegimeProfileService
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.model.concrete.CourseDiscipline
import app.com.eiduca.module.academic.repository.concrete.CourseDisciplineRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CourseDisciplineService(
    val courseDisciplineRepository: CourseDisciplineRepository
): DisciplineRegimeProfileService<CourseDiscipline>(courseDisciplineRepository) {

    fun findByCourse(course: Course) = courseDisciplineRepository.findByCourse(course)

    fun findByCourse(course: Course, pageable: Pageable) = courseDisciplineRepository.findByCourse(course, pageable)

    override fun findOrSave(obj: CourseDiscipline): CourseDiscipline {
        return courseDisciplineRepository.findByCourseAndDisciplineAndRegimeDisciplineAndProfileDiscipline(obj.course, obj.discipline, obj.regimeDiscipline, obj.profileDiscipline)
            .orElse(courseDisciplineRepository.save(obj))
    }

    override fun saveOrUpdate(obj: CourseDiscipline): CourseDiscipline {
        courseDisciplineRepository.findByCourseAndDisciplineAndRegimeDisciplineAndProfileDiscipline(obj.course, obj.discipline, obj.regimeDiscipline, obj.profileDiscipline).ifPresent { obj.id = it.id }
        return courseDisciplineRepository.save(obj)
    }

    override fun deleteIfExist(obj: CourseDiscipline) {
        courseDisciplineRepository.findByCourseAndDisciplineAndRegimeDisciplineAndProfileDiscipline(obj.course, obj.discipline, obj.regimeDiscipline, obj.profileDiscipline).ifPresent { hidden(it) }
    }

    override fun destroyIfExist(obj: CourseDiscipline) {
        courseDisciplineRepository.findByCourseAndDisciplineAndRegimeDisciplineAndProfileDiscipline(obj.course, obj.discipline, obj.regimeDiscipline, obj.profileDiscipline).ifPresent { destroy(it) }
    }

}