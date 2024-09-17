package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.concrete.DayPeriodCreate
import app.com.eiduca.module.academic.model.concrete.DayPeriod
import app.com.eiduca.module.academic.service.concrete.DayPeriodService
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of day periods")
class DayPeriodControllerIT (
    @Autowired var dayPeriodService: DayPeriodService
): ConcreteControllerItTest<DayPeriod>(
    dayPeriodService,
    DayPeriodCreate.DAY_PERIOD_SAVE,
    "day-periods"
) {
    override fun requestModel() = model.toRequest()
}