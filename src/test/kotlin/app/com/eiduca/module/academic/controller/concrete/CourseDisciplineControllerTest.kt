package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.CourseDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.CourseDiscipline
import app.com.eiduca.module.academic.request.concrete.CourseDisciplineRequest
import app.com.eiduca.module.academic.service.concrete.CourseDisciplineService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of courseDiscipline controller")
class CourseDisciplineControllerTest: ConcreteControllerTest<CourseDiscipline, CourseDisciplineRequest>() {
    @InjectMocks
    lateinit var courseDisciplineController: CourseDisciplineController
    @Mock
    lateinit var courseDisciplineService: CourseDisciplineService

    @BeforeEach
    fun setUp() {
        setUpConcrete(courseDisciplineController, courseDisciplineService, CourseDisciplineCreate.COURSE_DISCIPLINE_SAVE)
    }

    override fun createModel() = courseDisciplineController.save(model.toRequest())

    override fun updateModel() = courseDisciplineController.update(model.toRequest(), model.id)
}