package app.com.eiduca.module.core.seed.concrete

import app.com.eiduca.module.core.enums.EntityEnum
import app.com.eiduca.module.core.factory.concrete.PermissionFactory
import app.com.eiduca.module.core.model.concrect.Permission

enum class PermissionSeed (val permission: Permission) {

    PERMISSION_SUPER(PermissionFactory.build("SUPER", "Has full permission on the system", EntityEnum.APPLICATION)),

    PERMISSION_VIEW(PermissionFactory.build("VIEW_PERMISSION", "View permissions", EntityEnum.PERMISSION)),
    PERMISSION_SAVE(PermissionFactory.build("SAVE_PERMISSION", "Save permission", EntityEnum.PERMISSION)),
    PERMISSION_UPDATE(PermissionFactory.build("UPDATE_PERMISSION", "Edit permission", EntityEnum.PERMISSION)),
    PERMISSION_DELETE(PermissionFactory.build("DELETE_PERMISSION", "Delete permission", EntityEnum.PERMISSION)),

    ROLE_VIEW(PermissionFactory.build("VIEW_ROLE", "View job titles", EntityEnum.ROLE)),
    ROLE_SAVE(PermissionFactory.build("SAVE_ROLE", "Save position", EntityEnum.ROLE)),
    ROLE_UPDATE(PermissionFactory.build("UPDATE_ROLE", "Edit job title", EntityEnum.ROLE)),
    ROLE_DELETE(PermissionFactory.build("DELETE_ROLE", "Delete position", EntityEnum.ROLE)),

    PERSON_VIEW(PermissionFactory.build("VIEW_PERSON", "View users", EntityEnum.PERSON)),
    PERSON_SAVE(PermissionFactory.build("SAVE_PERSON", "Save user", EntityEnum.PERSON)),
    PERSON_UPDATE(PermissionFactory.build("UPDATE_PERSON", "Edit user", EntityEnum.PERSON)),
    PERSON_DELETE(PermissionFactory.build("DELETE_PERSON", "Delete user", EntityEnum.PERSON)),

    IDENTITY_CARD_VIEW(PermissionFactory.build("VIEW_IDENTITY_CARD", "View identity card", EntityEnum.IDENTITY_CARD)),
    IDENTITY_CARD_SAVE(PermissionFactory.build("SAVE_IDENTITY_CARD", "Save identity card", EntityEnum.IDENTITY_CARD)),
    IDENTITY_CARD_UPDATE(PermissionFactory.build("UPDATE_IDENTITY_CARD", "Edit identity card", EntityEnum.IDENTITY_CARD)),
    IDENTITY_CARD_DELETE(PermissionFactory.build("DELETE_IDENTITY_CARD", "Delete identity card", EntityEnum.IDENTITY_CARD)),

    ADDRESS_VIEW(PermissionFactory.build("VIEW_ADDRESS", "View address", EntityEnum.ADDRESS)),
    ADDRESS_SAVE(PermissionFactory.build("SAVE_ADDRESS", "Save address", EntityEnum.ADDRESS)),
    ADDRESS_UPDATE(PermissionFactory.build("UPDATE_ADDRESS", "Edit address", EntityEnum.ADDRESS)),
    ADDRESS_DELETE(PermissionFactory.build("DELETE_ADDRESS", "Delete address", EntityEnum.ADDRESS)),

    PERSON_ADDRESS_VIEW(PermissionFactory.build("VIEW_PERSON_ADDRESS", "View address of user", EntityEnum.PERSON_ADDRESS)),
    PERSON_ADDRESS_SAVE(PermissionFactory.build("SAVE_PERSON_ADDRESS", "Save address of user", EntityEnum.PERSON_ADDRESS)),
    PERSON_ADDRESS_UPDATE(PermissionFactory.build("UPDATE_PERSON_ADDRESS", "Edit address of user", EntityEnum.PERSON_ADDRESS)),
    PERSON_ADDRESS_DELETE(PermissionFactory.build("DELETE_PERSON_ADDRESS", "Delete address of user", EntityEnum.PERSON_ADDRESS)),
}