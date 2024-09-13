package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.DayPeriodCreate
import app.com.eiduca.module.academic.model.concrete.DayPeriod
import app.com.eiduca.module.academic.request.concrete.DayPeriodRequest
import app.com.eiduca.module.academic.service.concrete.DayPeriodService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of dayPeriod controller")
class DayPeriodControllerTest: ConcreteControllerTest<DayPeriod, DayPeriodRequest>() {
    @InjectMocks
    lateinit var dayPeriodController: DayPeriodController
    @Mock
    lateinit var dayPeriodService: DayPeriodService

    @BeforeEach
    fun setUp() {
        setUpConcrete(dayPeriodController, dayPeriodService, DayPeriodCreate.DAY_PERIOD_SAVE)
    }

    override fun createModel(): ResponseEntity<DayPeriod> = dayPeriodController.save(model.toRequest())

    override fun updateModel(): ResponseEntity<DayPeriod> = dayPeriodController.update(model.toRequest(), model.id)
}