package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.DisciplineCreate
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.academic.request.concrete.DisciplineRequest
import app.com.eiduca.module.academic.service.concrete.DisciplineService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of discipline controller")
class DisciplineControllerTest: ConcreteControllerTest<Discipline, DisciplineRequest>() {
    @InjectMocks
    lateinit var disciplineController: DisciplineController
    @Mock
    lateinit var disciplineService: DisciplineService

    @BeforeEach
    fun setUp() {
        setUpConcrete(disciplineController, disciplineService, DisciplineCreate.DISCIPLINE_SAVE)
    }

    override fun createModel(): ResponseEntity<Discipline> = disciplineController.save(model.toDisciplineRequest())

    override fun updateModel(): ResponseEntity<Discipline> = disciplineController.update(model.toDisciplineRequest(), model.id)
}