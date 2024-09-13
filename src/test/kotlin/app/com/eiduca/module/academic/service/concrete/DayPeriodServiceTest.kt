package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionServiceTest
import app.com.eiduca.module.academic.create.concrete.DayPeriodCreate
import app.com.eiduca.module.academic.model.concrete.DayPeriod
import app.com.eiduca.module.academic.repository.concrete.DayPeriodRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of dayPeriod service")
class DayPeriodServiceTest: CodeNamedDescriptionServiceTest<DayPeriod>(){
    @InjectMocks
    lateinit var dayPeriodService: DayPeriodService
    @Mock
    lateinit var dayPeriodRepository: DayPeriodRepository

    @BeforeEach
    fun setUpDayPeriod() {
        setUpCodeNamedDescription(dayPeriodService, dayPeriodRepository, DayPeriodCreate.DAY_PERIOD_SAVE)
    }
}