package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.named.NamedDescriptionService
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.repository.concrect.PermissionRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PermissionService(
    val permissionRepository: PermissionRepository
): NamedDescriptionService<Permission>(permissionRepository) {

    fun findByEntity(entity: String): List<Permission> = permissionRepository.findByEntity(entity)

    fun findByEntity(entity: String, pageable: Pageable): Page<Permission> = permissionRepository.findByEntity(entity, pageable)
}