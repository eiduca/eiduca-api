package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.concrete.ClassroomDisciplineCreate
import app.com.eiduca.module.academic.initializer.service.ClassroomDisciplineInitializer
import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline
import app.com.eiduca.module.academic.service.concrete.*
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of classroomDiscipline")
class ClassroomDisciplineControllerIT (
    @Autowired var classroomDisciplineService: ClassroomDisciplineService,
    @Autowired var classroomDisciplineInitializer: ClassroomDisciplineInitializer
): ConcreteControllerItTest<ClassroomDiscipline>(
    classroomDisciplineService,
    ClassroomDisciplineCreate.CLASSROOM_DISCIPLINE_SAVE,
    "classroom-disciplines"
) {
    override fun requestModel() = model.toRequest()

    override fun runner() {
        model = classroomDisciplineInitializer.initialize(model)
        model = classroomDisciplineService.saveOrUpdate(model)
    }

    override fun runnerSave() {
        classroomDisciplineService.destroyIfExist(model)
    }
}