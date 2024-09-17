package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.RegimeDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline
import app.com.eiduca.module.academic.request.concrete.RegimeDisciplineRequest
import app.com.eiduca.module.academic.service.concrete.RegimeDisciplineService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of regime discipline controller")
class RegimeDisciplineControllerTest: ConcreteControllerTest<RegimeDiscipline, RegimeDisciplineRequest>() {
    @InjectMocks
    lateinit var regimeDisciplineController: RegimeDisciplineController
    @Mock
    lateinit var regimeDisciplineService: RegimeDisciplineService

    @BeforeEach
    fun setUp() {
        setUpConcrete(regimeDisciplineController, regimeDisciplineService, RegimeDisciplineCreate.REGIME_DISCIPLINE_SAVE)
    }

    override fun createModel() = regimeDisciplineController.save(model.toRequest())

    override fun updateModel() = regimeDisciplineController.update(model.toRequest(), model.id)
}