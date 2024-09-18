package app.com.eiduca.module.academic.initializer.service

import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline
import app.com.eiduca.module.academic.service.concrete.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ClassroomDisciplineInitializer(
    @Autowired private val classroomInitializer: ClassroomInitializer,

    @Autowired private val classroomService: ClassroomService,
    @Autowired private val disciplineService: DisciplineService,
    @Autowired private val regimeDisciplineService: RegimeDisciplineService,
    @Autowired private val profileDisciplineService: ProfileDisciplineService
) {

    fun initialize(obj: ClassroomDiscipline): ClassroomDiscipline {
        obj.classroom = classroomInitializer.initialize(obj.classroom)

        obj.classroom = classroomService.saveOrUpdate(obj.classroom)
        obj.discipline = disciplineService.saveOrUpdate(obj.discipline)
        obj.regimeDiscipline = regimeDisciplineService.saveOrUpdate(obj.regimeDiscipline)
        obj.profileDiscipline = profileDisciplineService.saveOrUpdate(obj.profileDiscipline)

        return obj
    }

}
