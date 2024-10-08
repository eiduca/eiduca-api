package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.CourseCreate
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.academic.request.concrete.CourseRequest
import app.com.eiduca.module.academic.service.concrete.CourseService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of course controller")
class CourseControllerTest: ConcreteControllerTest<Course, CourseRequest>() {
    @InjectMocks
    lateinit var courseController: CourseController
    @Mock
    lateinit var courseService: CourseService

    @BeforeEach
    fun setUp() {
        setUpConcrete(courseController, courseService, CourseCreate.COURSE_SAVE)
    }

    override fun createModel() = courseController.save(model.toRequest())

    override fun updateModel() = courseController.update(model.toRequest(), model.id)
}