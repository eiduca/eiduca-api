package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionRepository
import app.com.eiduca.module.academic.model.concrete.Discipline
import org.springframework.stereotype.Repository

@Repository
interface DisciplineRepository: CodeNamedDescriptionRepository<Discipline>