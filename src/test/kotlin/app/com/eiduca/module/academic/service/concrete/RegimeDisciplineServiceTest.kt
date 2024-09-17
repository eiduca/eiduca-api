package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionServiceTest
import app.com.eiduca.module.academic.create.concrete.RegimeDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline
import app.com.eiduca.module.academic.repository.concrete.RegimeDisciplineRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of regime discipline service")
class RegimeDisciplineServiceTest: CodeNamedDescriptionServiceTest<RegimeDiscipline>(){
    @InjectMocks
    lateinit var regimeDisciplineService: RegimeDisciplineService
    @Mock
    lateinit var regimeDisciplineRepository: RegimeDisciplineRepository

    @BeforeEach
    fun setUp() {
        setUpCodeNamedDescription(regimeDisciplineService, regimeDisciplineRepository, RegimeDisciplineCreate.REGIME_DISCIPLINE_SAVE)
    }
}