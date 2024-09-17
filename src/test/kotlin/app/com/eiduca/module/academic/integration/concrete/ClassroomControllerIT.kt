package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.concrete.ClassroomCreate
import app.com.eiduca.module.academic.initializer.ClassroomInitializer
import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.module.academic.service.concrete.*
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of classroom")
class ClassroomControllerIT (
    @Autowired var classroomService: ClassroomService,
    @Autowired var classroomInitializer: ClassroomInitializer
): ConcreteControllerItTest<Classroom>(
    classroomService,
    ClassroomCreate.CLASSROOM_SAVE,
    "classrooms"
) {
    override fun requestModel() = model.toRequest()

    override fun runnerSave() {
        model = classroomInitializer.initialize(model)
        classroomService.destroyAll()
    }
}