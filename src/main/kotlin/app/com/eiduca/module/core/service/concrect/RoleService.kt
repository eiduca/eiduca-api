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

    fun findByDescription(description: String): Role = roleRepository.findByDescription(description).orElseThrow { NotFoundException("Not found role by description [$description]") }

   override fun saveOrUpdate(obj: Role): Role {
        roleRepository.findByName(obj.name).ifPresent { obj.id = it.id }
        return  roleRepository.save(obj)
    }

}