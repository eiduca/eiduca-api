package app.com.eiduca.module.core.create.concrete

import app.com.eiduca.module.core.factory.PermissionFactory
import app.com.eiduca.module.core.seed.PermissionSeed

class PermissionCreate {
    companion object{
        val PERMISSION_SAVE = PermissionSeed.PERMISSION_SAVE.permission
        val PERMISSION_NOT_EXIST = PermissionFactory.build("TEST", "Administrator test")
    }
}