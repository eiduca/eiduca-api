package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.concrete.CourseDisciplineCreate
import app.com.eiduca.module.academic.initializer.service.CourseDisciplineInitializer
import app.com.eiduca.module.academic.model.concrete.CourseDiscipline
import app.com.eiduca.module.academic.service.concrete.*
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of courseDiscipline")
class CourseDisciplineControllerIT (
    @Autowired var courseDisciplineService: CourseDisciplineService,
    @Autowired var courseDisciplineInitializer: CourseDisciplineInitializer
): ConcreteControllerItTest<CourseDiscipline>(
    courseDisciplineService,
    CourseDisciplineCreate.COURSE_DISCIPLINE_SAVE,
    "course-disciplines"
) {
    override fun requestModel() = model.toRequest()

    override fun runner() {
        model = courseDisciplineInitializer.initialize(model)
        model = courseDisciplineService.saveOrUpdate(model)
    }

    override fun runnerSave() {
        courseDisciplineService.destroyIfExist(model)
    }
}