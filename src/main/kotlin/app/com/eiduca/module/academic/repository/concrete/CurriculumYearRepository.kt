package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionRepository
import app.com.eiduca.module.academic.model.concrete.CurriculumYear
import org.springframework.stereotype.Repository

@Repository
interface CurriculumYearRepository: OrderCodeNamedDescriptionRepository<CurriculumYear>