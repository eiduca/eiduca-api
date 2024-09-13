package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.request.PermissionRequest
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.module.core.service.concrect.PermissionService
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid

@RestController
@RequestMapping("\${apiPrefix}/permissions")
class PermissionController(
    val permissionService: PermissionService
): ConcreteController<Permission, PermissionRequest>(permissionService) {

    @GetMapping
    @HasPermission(PermissionSeed.PERMISSION_VIEW)
    @Operation(tags = ["permission"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable) = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.PERMISSION_VIEW)
    @Operation(tags = ["permission"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String) = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.PERMISSION_SAVE)
    @Operation(tags = ["permission"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: PermissionRequest) = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.PERMISSION_UPDATE)
    @Operation(tags = ["permission"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: PermissionRequest, @PathVariable id: String) = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.PERMISSION_DELETE)
    @Operation(tags = ["permission"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String) = super.deleteById(id)
}