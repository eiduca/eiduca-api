package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.ProfileDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline
import app.com.eiduca.module.academic.request.concrete.ProfileDisciplineRequest
import app.com.eiduca.module.academic.service.concrete.ProfileDisciplineService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of profile discipline controller")
class ProfileDisciplineControllerTest: ConcreteControllerTest<ProfileDiscipline, ProfileDisciplineRequest>() {
    @InjectMocks
    lateinit var profileDisciplineController: ProfileDisciplineController
    @Mock
    lateinit var profileDisciplineService: ProfileDisciplineService

    @BeforeEach
    fun setUp() {
        setUpConcrete(profileDisciplineController, profileDisciplineService, ProfileDisciplineCreate.PROFILE_DISCIPLINE_SAVE)
    }

    override fun createModel() = profileDisciplineController.save(model.toRequest())

    override fun updateModel() = profileDisciplineController.update(model.toRequest(), model.id)
}