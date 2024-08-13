package app.com.eiduca.module.core.request.body

import app.com.eiduca.module.core.builder.concrect.RoleBuilder
import app.com.eiduca.module.core.model.concrect.Role
import io.swagger.v3.oas.annotations.media.Schema

class RoleRequest(
    @Schema(description = "Role's name or codename", example = "ROLE_TEACHER")
    var name: String,
    @Schema(description = "Role's description", example = "Represent teachers")
    var description: String,
) {

    fun toRole() : Role = RoleBuilder().name(name).description(description).build()
}