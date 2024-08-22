package app.com.eiduca.module.core.seed.concrete

import app.com.eiduca.module.core.factory.concrete.RoleFactory
import app.com.eiduca.module.core.model.concrect.Role

enum class RoleSeed(val role: Role) {
    SUPER(RoleFactory.build("SUPER", "Permissão total")),
    ADMIN(RoleFactory.build("ADMIN", "Administrador do sistema")),
    DEV(RoleFactory.build("DEV", "Desenvolvedor do sistema")),
    ROLE(RoleFactory.build("ROLE", "Administrador de cargos")),
    PERMISSION(RoleFactory.build("PERMISSION", "Administrador de permissões")),
    PERSON(RoleFactory.build("PERSON", "Administrador de utilizadores")),
    IDENTITY_CARD(RoleFactory.build("IDENTITY_CARD", "Administrador de bilhete de identidade")),
}