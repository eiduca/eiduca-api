package app.com.eiduca.module.core.component

import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.model.concrect.Role
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.module.core.seed.PersonSeed
import app.com.eiduca.module.core.seed.RoleSeed
import app.com.eiduca.module.core.service.concrect.PermissionService
import app.com.eiduca.module.core.service.concrect.PersonService
import app.com.eiduca.module.core.service.concrect.RoleService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DatabaseRunner(
    val roleService: RoleService,
    val personService: PersonService,
    val permissionService: PermissionService
): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val roles: MutableList<Role> = mutableListOf()
        val persons: MutableList<Person> = mutableListOf()
        val permissions: MutableList<Permission> = mutableListOf()

        RoleSeed.entries.forEach { roles.addLast(roleService.saveOrUpdate(it.role))  }
        PersonSeed.entries.forEach { persons.addLast(personService.saveOrUpdate(it.person)) }
        PermissionSeed.entries.forEach { permissions.addLast(permissionService.saveOrUpdate(it.permission))  }
    }

}