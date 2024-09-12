package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionService
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.academic.repository.concrete.DisciplineRepository
import org.springframework.stereotype.Service

@Service
class DisciplineService(
    disciplineRepository: DisciplineRepository
): CodeNamedDescriptionService<Discipline>(disciplineRepository)