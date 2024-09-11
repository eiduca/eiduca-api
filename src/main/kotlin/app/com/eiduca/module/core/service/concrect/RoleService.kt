package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.named.NamedDescriptionService
import app.com.eiduca.module.core.model.concrect.Role
import app.com.eiduca.module.core.repository.concrect.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleService(
    roleRepository: RoleRepository
): NamedDescriptionService<Role>(roleRepository)