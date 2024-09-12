package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiConfigureTestIT
import app.com.eiduca.module.academic.create.concrete.InstitutionCreate
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.request.concrete.InstitutionRequest
import app.com.eiduca.module.academic.service.concrete.InstitutionService
import app.com.eiduca.module.academic.service.concrete.UniversityService
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiConfigureTestIT
@DisplayName("Test integration of institution")
class InstitutionControllerIT (
    @Autowired val institutionService: InstitutionService,
    @Autowired val universityService: UniversityService,
): ConcreteControllerItTest<Institution>(
    institutionService,
    InstitutionCreate.INSTITUTION_SAVE,
    "institutions"
) {
    override fun requestModel(): InstitutionRequest = model.toInstitutionRequest()

    override fun runner() {
        model.university = universityService.saveOrUpdate(model.university)
    }
}