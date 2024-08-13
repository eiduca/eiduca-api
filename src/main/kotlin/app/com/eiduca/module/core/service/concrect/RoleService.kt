package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.Role
import app.com.eiduca.module.core.repository.concrect.RoleConcreteRepository
import org.springframework.stereotype.Service

@Service
class RoleService(
    val roleRepository: RoleConcreteRepository
): ConcreteService<Role>(roleRepository) {

    fun findByName(name: String): Role = roleRepository.findByName(name).orElseThrow { NotFoundException("Not found role by name [$name]") }

}