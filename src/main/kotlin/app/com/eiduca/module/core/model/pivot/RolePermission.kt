package app.com.eiduca.module.core.model.pivot

import app.com.eiduca.module.core.common.PivotModel
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.model.concrect.Role
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_role_permission")
class RolePermission(
    var role: Role,
    var permission: Permission,
): PivotModel() {

}