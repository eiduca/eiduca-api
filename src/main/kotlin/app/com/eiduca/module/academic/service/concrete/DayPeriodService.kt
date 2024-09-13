package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionService
import app.com.eiduca.module.academic.model.concrete.DayPeriod
import app.com.eiduca.module.academic.repository.concrete.DayPeriodRepository
import org.springframework.stereotype.Service

@Service
class DayPeriodService(
    dayPeriodRepository: DayPeriodRepository
): CodeNamedDescriptionService<DayPeriod>(dayPeriodRepository)