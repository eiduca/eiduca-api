package app.com.eiduca.module.academic.initializer

import app.com.eiduca.module.academic.model.concrete.CourseDiscipline
import app.com.eiduca.module.academic.service.concrete.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CourseDisciplineInitializer(
    @Autowired private val courseInitializer: CourseInitializer,

    @Autowired private val courseService: CourseService,
    @Autowired private val disciplineService: DisciplineService,
    @Autowired private val regimeDisciplineService: RegimeDisciplineService,
    @Autowired private val profileDisciplineService: ProfileDisciplineService
) {
    fun initialize(obj: CourseDiscipline): CourseDiscipline {
        obj.course = courseInitializer.initialize(obj.course)

        obj.course = courseService.saveOrUpdate(obj.course)
        obj.discipline = disciplineService.saveOrUpdate(obj.discipline)
        obj.regimeDiscipline = regimeDisciplineService.saveOrUpdate(obj.regimeDiscipline)
        obj.profileDiscipline = profileDisciplineService.saveOrUpdate(obj.profileDiscipline)

        return obj
    }
}
