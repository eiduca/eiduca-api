package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.create.concrete.CourseCreate
import app.com.eiduca.module.academic.initializer.service.CourseInitializer
import app.com.eiduca.module.academic.service.concrete.CourseService
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of course")
class CourseControllerIT (
    @Autowired var courseService: CourseService,
    @Autowired var courseInitializer: CourseInitializer,
): ConcreteControllerItTest<Course>(
    courseService,
    CourseCreate.COURSE_SAVE,
    "courses"
) {
    override fun requestModel() = model.toRequest()

    override fun runner() {
        model = courseInitializer.initialize(model)
    }
}