package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.ConcreteRepository
import app.com.eiduca.module.core.model.concrect.Permission
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PermissionConcreteRepository: ConcreteRepository<Permission> {
    @Query(name = "SELECT p FROM Permission p WHERE name = :name AND deletedBy IS NULL AND deletedAt is NULL")
    fun findByName(name: String): Optional<Permission>
}