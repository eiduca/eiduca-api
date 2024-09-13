package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionRepositoryTest
import app.com.eiduca.module.academic.create.concrete.DayPeriodCreate
import app.com.eiduca.module.academic.model.concrete.DayPeriod
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of dayPeriod repository")
class DayPeriodRepositoryTest(
    @Autowired val dayPeriodRepository: DayPeriodRepository
): CodeNamedDescriptionRepositoryTest<DayPeriod>(dayPeriodRepository, DayPeriodCreate.DAY_PERIOD_SAVE)