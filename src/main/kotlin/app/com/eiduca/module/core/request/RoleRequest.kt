package app.com.eiduca.module.core.request

import app.com.eiduca.module.core.builder.RoleBuilder
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.model.concrect.Role
import io.swagger.v3.oas.annotations.media.Schema

data class RoleRequest(
    @Schema(description = "Role's name or codename", example = "ROLE_TEACHER")
    var name: String,
    @Schema(description = "Role's description", example = "Represent teachers")
    var description: String,
): IConvertModel<Role> {

    override fun toModel() : Role = RoleBuilder().name(name).description(description).build()
}