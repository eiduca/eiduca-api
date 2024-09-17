package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionService
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline
import app.com.eiduca.module.academic.repository.concrete.ProfileDisciplineRepository
import org.springframework.stereotype.Service

@Service
class ProfileDisciplineService(
    profileDisciplineRepository: ProfileDisciplineRepository
): CodeNamedDescriptionService<ProfileDiscipline>(profileDisciplineRepository)