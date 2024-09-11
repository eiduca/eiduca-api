package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.named.NamedDescriptionRepository
import app.com.eiduca.module.core.model.concrect.Role
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository: NamedDescriptionRepository<Role>