package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.concrete.AcademicPeriodCreate
import app.com.eiduca.module.academic.model.concrete.AcademicPeriod
import app.com.eiduca.module.academic.service.concrete.AcademicPeriodService
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of academic period")
class AcademicPeriodControllerIT (
    @Autowired var academicPeriodService: AcademicPeriodService
): ConcreteControllerItTest<AcademicPeriod>(
    academicPeriodService,
    AcademicPeriodCreate.ACADEMIC_PERIOD_SAVE,
    "academic-periods"
) {
    override fun requestModel() = model.toRequest()
}