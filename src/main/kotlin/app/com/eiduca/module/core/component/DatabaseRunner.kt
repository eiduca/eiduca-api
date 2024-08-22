package app.com.eiduca.module.core.component

import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.model.concrect.Role
import app.com.eiduca.module.core.seed.concrete.IdentityCardSeed
import app.com.eiduca.module.core.seed.concrete.PermissionSeed
import app.com.eiduca.module.core.seed.concrete.PersonSeed
import app.com.eiduca.module.core.seed.concrete.RoleSeed
import app.com.eiduca.module.core.service.concrect.IdentityCardService
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
    val permissionService: PermissionService,
    val identityCardService: IdentityCardService
): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val roles: MutableList<Role> = mutableListOf()
        val persons: MutableList<Person> = mutableListOf()
        val permissions: MutableList<Permission> = mutableListOf()

        RoleSeed.entries.forEach { roles.addLast(roleService.saveOrUpdate(it.role))  }
        PersonSeed.entries.forEach { persons.addLast(personService.saveOrUpdate(it.person)) }
        PermissionSeed.entries.forEach { permissions.addLast(permissionService.saveOrUpdate(it.permission)) }
        IdentityCardSeed.entries.forEach {
            it.identityCard.person = persons.first { p -> p.username == it.identityCard.person.username }
            identityCardService.saveOrUpdate(it.identityCard)
        }
    }

}