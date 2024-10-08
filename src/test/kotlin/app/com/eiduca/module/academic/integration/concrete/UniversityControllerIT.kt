package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.concrete.UniversityCreate
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.academic.service.concrete.UniversityService
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of university")
class UniversityControllerIT (
    @Autowired val universityService: UniversityService,
): ConcreteControllerItTest<University>(
    universityService,
    UniversityCreate.UNIVERSITY_SAVE,
    "universities"
) {
    override fun requestModel() = model.toRequest()
}