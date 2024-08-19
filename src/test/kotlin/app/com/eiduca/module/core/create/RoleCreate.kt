package app.com.eiduca.module.core.create

import app.com.eiduca.module.core.factory.RoleFactory
import app.com.eiduca.module.core.seed.PersonSeed
import app.com.eiduca.module.core.seed.RoleSeed
import app.com.eiduca.module.core.util.GeneratorUUID

class RoleCreate {

    companion object{

        val ROLE_SAVE = RoleSeed.PERSON.role

        val ROLE_UPDATE = ROLE_SAVE.apply { id = GeneratorUUID.v7toString() }

        val ROLE_NOT_EXIST = RoleFactory.build("TEST", "Administrador de teste")

    }

}