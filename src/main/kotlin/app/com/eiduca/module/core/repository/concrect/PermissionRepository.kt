package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.named.NamedDescriptionRepository
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.query.PermissionJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface PermissionRepository: NamedDescriptionRepository<Permission> {
    @Query(name = PermissionJPQL.FIND_ALL_ENTITY)
    fun findByEntity(entity: String): List<Permission>

    @Query(name = PermissionJPQL.FIND_ALL_ENTITY, countName = PermissionJPQL.FIND_COUNT_ENTITY)
    fun findByEntity(entity: String, pageable: Pageable): Page<Permission>
}