package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionService
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline
import app.com.eiduca.module.academic.repository.concrete.RegimeDisciplineRepository
import org.springframework.stereotype.Service

@Service
class RegimeDisciplineService(
    regimeDisciplineRepository: RegimeDisciplineRepository
): CodeNamedDescriptionService<RegimeDiscipline>(regimeDisciplineRepository)