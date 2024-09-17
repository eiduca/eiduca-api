package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.concrete.DisciplineCreate
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.academic.service.concrete.DisciplineService
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of discipline")
class DisciplineControllerIT (
    @Autowired var disciplineService: DisciplineService
): ConcreteControllerItTest<Discipline>(
    disciplineService,
    DisciplineCreate.DISCIPLINE_SAVE,
    "disciplines"
) {
    override fun requestModel() = model.toRequest()
}