package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionRepository
import app.com.eiduca.module.academic.model.concrete.AcademicPeriod
import org.springframework.stereotype.Repository

@Repository
interface AcademicPeriodRepository: OrderCodeNamedDescriptionRepository<AcademicPeriod>