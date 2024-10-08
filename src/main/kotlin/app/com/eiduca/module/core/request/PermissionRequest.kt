package app.com.eiduca.module.core.request

import app.com.eiduca.module.core.builder.PermissionBuilder
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.model.concrect.Permission
import io.swagger.v3.oas.annotations.media.Schema

data class PermissionRequest(
    @Schema(description = "Permission's name or codename", example = "PERSON_CREATE")
    var name: String,
    @Schema(description = "Permission's description", example = "Permit create person")
    var description: String,
    @Schema(description = "Model represent permission", example = "Person")
    var entity: String
): IConvertModel<Permission> {

    override fun toModel(): Permission = PermissionBuilder().entity(entity).name(name).description(description).build()

}