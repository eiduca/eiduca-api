package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.repository.concrect.PermissionRepository
import org.springframework.stereotype.Service

@Service
class PermissionService(
    val permissionRepository: PermissionRepository
): ConcreteService<Permission>(permissionRepository) {

    fun findByName(name: String): Permission = permissionRepository.findByName(name).orElseThrow { NotFoundException("Not found permission by name [$name]") }

}