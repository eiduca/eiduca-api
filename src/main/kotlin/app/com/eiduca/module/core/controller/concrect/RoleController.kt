package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.model.concrect.Role
import app.com.eiduca.module.core.request.RoleRequest
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.module.core.service.concrect.RoleService
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${apiPrefix}/roles")
class RoleController(
    roleService: RoleService
): ConcreteController<Role, RoleRequest>(roleService) {

    @GetMapping
    @HasPermission(PermissionSeed.ROLE_VIEW)
    @Operation(tags = ["role"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable): ResponseEntity<Page<Role>> = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.ROLE_VIEW)
    @Operation(tags = ["role"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String): ResponseEntity<Role> = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.ROLE_SAVE)
    @Operation(tags = ["role"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: RoleRequest): ResponseEntity<Role> = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.ROLE_UPDATE)
    @Operation(tags = ["role"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: RoleRequest, @PathVariable id: String): ResponseEntity<Role> = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.ROLE_DELETE)
    @Operation(tags = ["role"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String): ResponseEntity<Unit> = super.deleteById(id)
}