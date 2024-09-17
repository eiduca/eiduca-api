package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.concrete.AcademicYearCreate
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.academic.service.concrete.AcademicYearService
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of academic year")
class AcademicYearControllerIT (
    @Autowired val academicYearService: AcademicYearService,
): ConcreteControllerItTest<AcademicYear>(
    academicYearService,
    AcademicYearCreate.ACADEMIC_YEAR_SAVE,
    "academic-years"
) {
    override fun requestModel() = model.toRequest()
}