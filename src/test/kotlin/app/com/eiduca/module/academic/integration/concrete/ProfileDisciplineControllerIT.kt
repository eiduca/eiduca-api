package app.com.eiduca.module.academic.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.concrete.ProfileDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline
import app.com.eiduca.module.academic.service.concrete.ProfileDisciplineService
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of profile discipline")
class ProfileDisciplineControllerIT (
    @Autowired var profileDisciplineService: ProfileDisciplineService
): ConcreteControllerItTest<ProfileDiscipline>(
    profileDisciplineService,
    ProfileDisciplineCreate.PROFILE_DISCIPLINE_SAVE,
    "profile-disciplines"
) {
    override fun requestModel() = model.toRequest()
}