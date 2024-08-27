package app.com.eiduca.module.core.create.concrete

import app.com.eiduca.module.core.factory.PermissionFactory
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.module.core.util.GeneratorUUID

class PermissionCreate {

    companion object{

        val PERMISSION_SAVE = PermissionSeed.PERMISSION_SAVE.permission

        val PERMISSION_UPDATE = PERMISSION_SAVE.apply { id = GeneratorUUID.v7toString() }

        val PERMISSION_NOT_EXIST = PermissionFactory.build("TEST", "Administrador de teste")

    }

}