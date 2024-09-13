package app.com.eiduca.module.core.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import app.com.eiduca.module.core.create.concrete.PermissionCreate
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.request.PermissionRequest
import app.com.eiduca.module.core.service.concrect.PermissionService
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of permission")
class PermissionControllerIT(
    @Autowired var permissionService: PermissionService
): ConcreteControllerItTest<Permission>(
    permissionService,
    PermissionCreate.PERMISSION_SAVE,
    "permissions"
) {
    override fun requestModel(): PermissionRequest = model.toRequest()
}