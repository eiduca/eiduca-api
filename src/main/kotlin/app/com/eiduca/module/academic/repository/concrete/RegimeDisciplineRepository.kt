package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionRepository
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline
import org.springframework.stereotype.Repository

@Repository
interface RegimeDisciplineRepository: CodeNamedDescriptionRepository<RegimeDiscipline>