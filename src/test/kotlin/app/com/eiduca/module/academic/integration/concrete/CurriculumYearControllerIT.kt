package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.model.concrete.CurriculumYear
import app.com.eiduca.module.academic.create.concrete.CurriculumYearCreate
import app.com.eiduca.module.academic.service.concrete.CurriculumYearService
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of curriculum years")
class CurriculumYearControllerIT (
    @Autowired var curriculumYearService: CurriculumYearService
): ConcreteControllerItTest<CurriculumYear>(
    curriculumYearService,
    CurriculumYearCreate.CURRICULUM_YEAR_SAVE,
    "curriculum-years"
) {
    override fun requestModel() = model.toRequest()
}