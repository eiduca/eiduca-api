package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionServiceTest
import app.com.eiduca.module.academic.create.concrete.ProfileDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline
import app.com.eiduca.module.academic.repository.concrete.ProfileDisciplineRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of profile discipline service")
class ProfileDisciplineServiceTest: CodeNamedDescriptionServiceTest<ProfileDiscipline>(){
    @InjectMocks
    lateinit var profileDisciplineService: ProfileDisciplineService
    @Mock
    lateinit var profileDisciplineRepository: ProfileDisciplineRepository

    @BeforeEach
    fun setUp() {
        setUpCodeNamedDescription(profileDisciplineService, profileDisciplineRepository, ProfileDisciplineCreate.PROFILE_DISCIPLINE_SAVE)
    }
}