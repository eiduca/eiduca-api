package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionService
import app.com.eiduca.module.academic.model.concrete.AcademicPeriod
import app.com.eiduca.module.academic.repository.concrete.AcademicPeriodRepository
import org.springframework.stereotype.Service

@Service
class AcademicPeriodService(
    academicPeriodRepository: AcademicPeriodRepository
): OrderCodeNamedDescriptionService<AcademicPeriod>(academicPeriodRepository)