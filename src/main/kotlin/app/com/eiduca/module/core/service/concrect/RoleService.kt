package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.general.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.Role
import app.com.eiduca.module.core.repository.concrect.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleService(
    val roleRepository: RoleRepository
): ConcreteService<Role>(roleRepository) {

    fun findByName(name: String): Role = roleRepository.findByName(name).orElseThrow { NotFoundException("Not found role by name [$name]") }

    fun saveOrUpdate(role: Role): Role {
        roleRepository.findByName(role.name).ifPresent { role.id = it.id }
        return  roleRepository.save(role)
    }

}