package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionServiceTest
import app.com.eiduca.module.academic.create.concrete.AcademicPeriodCreate
import app.com.eiduca.module.academic.model.concrete.AcademicPeriod
import app.com.eiduca.module.academic.repository.concrete.AcademicPeriodRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of academic period service")
class AcademicPeriodRequestServiceTest: OrderCodeNamedDescriptionServiceTest<AcademicPeriod>(){
    @InjectMocks
    lateinit var academicPeriodService: AcademicPeriodService
    @Mock
    lateinit var academicPeriodRepository: AcademicPeriodRepository

    @BeforeEach
    fun setUp() {
        setUpOrderCodeNamedDescription(academicPeriodService, academicPeriodRepository, AcademicPeriodCreate.ACADEMIC_PERIOD_SAVE)
    }
}