package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.ConcreteRepository
import app.com.eiduca.module.core.model.concrect.Permission
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PermissionRepository: ConcreteRepository<Permission> {
    @Query(name = "ModelConcrete.findByName")
    fun findByName(name: String): Optional<Permission>
}