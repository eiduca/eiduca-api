package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.dscipline.DisciplineRegimeProfileService
import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline
import app.com.eiduca.module.academic.repository.concrete.ClassroomDisciplineRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ClassroomDisciplineService(
    val classroomDisciplineRepository: ClassroomDisciplineRepository
): DisciplineRegimeProfileService<ClassroomDiscipline>(classroomDisciplineRepository) {

    fun findByClassroom(classroom: Classroom) = classroomDisciplineRepository.findByClassroom(classroom)

    fun findByClassroom(classroom: Classroom, pageable: Pageable) = classroomDisciplineRepository.findByClassroom(classroom, pageable)

    override fun findOrSave(obj: ClassroomDiscipline): ClassroomDiscipline {
        return classroomDisciplineRepository.findByClassroomAndDisciplineAndRegimeDisciplineAndProfileDiscipline(obj.classroom, obj.discipline, obj.regimeDiscipline, obj.profileDiscipline)
            .orElse(classroomDisciplineRepository.save(obj))
    }

    override fun saveOrUpdate(obj: ClassroomDiscipline): ClassroomDiscipline {
        classroomDisciplineRepository.findByClassroomAndDisciplineAndRegimeDisciplineAndProfileDiscipline(obj.classroom, obj.discipline, obj.regimeDiscipline, obj.profileDiscipline).ifPresent { obj.id = it.id }
        return classroomDisciplineRepository.save(obj)
    }

    override fun deleteIfExist(obj: ClassroomDiscipline) {
        classroomDisciplineRepository.findByClassroomAndDisciplineAndRegimeDisciplineAndProfileDiscipline(obj.classroom, obj.discipline, obj.regimeDiscipline, obj.profileDiscipline).ifPresent { hidden(it) }
    }

    override fun destroyIfExist(obj: ClassroomDiscipline) {
        classroomDisciplineRepository.findByClassroomAndDisciplineAndRegimeDisciplineAndProfileDiscipline(obj.classroom, obj.discipline, obj.regimeDiscipline, obj.profileDiscipline).ifPresent { destroy(it) }
    }

}