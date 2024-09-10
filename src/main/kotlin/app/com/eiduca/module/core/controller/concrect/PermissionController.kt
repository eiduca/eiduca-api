package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.request.PermissionRequest
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.module.core.service.concrect.PermissionService
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
@RequestMapping("\${apiPrefix}/permissions")
class PermissionController(
    val permissionService: PermissionService
): ConcreteController<Permission, PermissionRequest>(permissionService) {

    @GetMapping
    @HasPermission(PermissionSeed.PERMISSION_VIEW)
    @Operation(tags = ["permission"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable): ResponseEntity<Page<Permission>> = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.PERMISSION_VIEW)
    @Operation(tags = ["permission"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String): ResponseEntity<Permission> = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.PERMISSION_SAVE)
    @Operation(tags = ["permission"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: PermissionRequest): ResponseEntity<Permission> = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.PERMISSION_UPDATE)
    @Operation(tags = ["permission"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: PermissionRequest, @PathVariable id: String): ResponseEntity<Permission> = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.PERMISSION_DELETE)
    @Operation(tags = ["permission"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String): ResponseEntity<Unit> = super.deleteById(id)
}