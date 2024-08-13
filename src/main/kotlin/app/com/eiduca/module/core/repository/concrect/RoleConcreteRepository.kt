package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.ConcreteRepository
import app.com.eiduca.module.core.model.concrect.Role
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface RoleConcreteRepository: ConcreteRepository<Role> {
    @Query(name = "SELECT r FROM Role r WHERE name = :name AND deletedBy IS NULL AND deletedAt is NULL")
    fun findByName(name: String): Optional<Role>
}