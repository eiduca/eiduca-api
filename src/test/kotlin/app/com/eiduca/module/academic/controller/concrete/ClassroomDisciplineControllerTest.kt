package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.ClassroomDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline
import app.com.eiduca.module.academic.request.concrete.ClassroomDisciplineRequest
import app.com.eiduca.module.academic.service.concrete.ClassroomDisciplineService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of classroomDiscipline controller")
class ClassroomDisciplineControllerTest: ConcreteControllerTest<ClassroomDiscipline, ClassroomDisciplineRequest>() {
    @InjectMocks
    lateinit var classroomDisciplineController: ClassroomDisciplineController
    @Mock
    lateinit var classroomDisciplineService: ClassroomDisciplineService

    @BeforeEach
    fun setUp() {
        setUpConcrete(classroomDisciplineController, classroomDisciplineService, ClassroomDisciplineCreate.CLASSROOM_DISCIPLINE_SAVE)
    }

    override fun createModel() = classroomDisciplineController.save(model.toRequest())

    override fun updateModel() = classroomDisciplineController.update(model.toRequest(), model.id)
}