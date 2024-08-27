package app.com.eiduca.module.core.seed

import app.com.eiduca.module.core.factory.RoleFactory
import app.com.eiduca.module.core.model.concrect.Role

enum class RoleSeed(val role: Role) {
    SUPER(RoleFactory.build("SUPER", "Full permission")),
    ADMIN(RoleFactory.build("ADMIN", "System administrator")),
    DEV(RoleFactory.build("DEV", "System developer")),
    ROLE(RoleFactory.build("ROLE", "Role administrator")),
    PERMISSION(RoleFactory.build("PERMISSION", "Permissions administrator")),
    PERSON(RoleFactory.build("PERSON", "User administrator")),
    ADDRESS(RoleFactory.build("ADDRESS", "Address administrator")),
    IDENTITY_CARD(RoleFactory.build("IDENTITY_CARD", "Identity card administrator")),
    PERSON_ADDRESS(RoleFactory.build("PERSON_ADDRESS", "Address of Person administrator")),
}