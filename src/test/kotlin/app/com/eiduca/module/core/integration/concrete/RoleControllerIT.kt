package app.com.eiduca.module.core.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import app.com.eiduca.module.core.create.concrete.RoleCreate
import app.com.eiduca.module.core.model.concrect.Role
import app.com.eiduca.module.core.request.RoleRequest
import app.com.eiduca.module.core.service.concrect.RoleService
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of role")
class RoleControllerIT(
    @Autowired val roleService: RoleService
): ConcreteControllerItTest<Role>(
    roleService,
    RoleCreate.ROLE_SAVE,
    "roles"
) {
    override fun requestModel(): RoleRequest = model.toRequest()
}