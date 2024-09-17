package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.concrete.RegimeDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline
import app.com.eiduca.module.academic.service.concrete.RegimeDisciplineService
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of regime discipline")
class RegimeDisciplineControllerIT (
    @Autowired var regimeDisciplineService: RegimeDisciplineService
): ConcreteControllerItTest<RegimeDiscipline>(
    regimeDisciplineService,
    RegimeDisciplineCreate.REGIME_DISCIPLINE_SAVE,
    "regime-disciplines"
) {
    override fun requestModel() = model.toRequest()
}