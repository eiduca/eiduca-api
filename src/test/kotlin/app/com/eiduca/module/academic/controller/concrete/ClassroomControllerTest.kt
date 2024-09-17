package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.ClassroomCreate
import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.module.academic.request.concrete.ClassroomRequest
import app.com.eiduca.module.academic.service.concrete.ClassroomService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of classroom controller")
class ClassroomControllerTest: ConcreteControllerTest<Classroom, ClassroomRequest>(){
    @InjectMocks
    lateinit var classroomController: ClassroomController
    @Mock
    lateinit var classroomService: ClassroomService

    @BeforeEach
    fun setUp() {
        setUpConcrete(classroomController, classroomService, ClassroomCreate.CLASSROOM_SAVE)
    }

    override fun createModel() = classroomController.save(model.toRequest())

    override fun updateModel() = classroomController.update(model.toRequest(), model.id)
}