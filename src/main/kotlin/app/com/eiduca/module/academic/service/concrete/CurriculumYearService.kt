package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionService
import app.com.eiduca.module.academic.model.concrete.CurriculumYear
import app.com.eiduca.module.academic.repository.concrete.CurriculumYearRepository
import org.springframework.stereotype.Service

@Service
class CurriculumYearService(
    curriculumYearRepository: CurriculumYearRepository
): OrderCodeNamedDescriptionService<CurriculumYear>(curriculumYearRepository)