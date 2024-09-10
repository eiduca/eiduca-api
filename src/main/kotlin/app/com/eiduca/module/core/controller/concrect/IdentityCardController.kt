package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.request.IdentityCardRequest
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.module.core.service.concrect.IdentityCardService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
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
@RequestMapping("\${apiPrefix}/identity-cards")
class IdentityCardController(
    val identityCardService: IdentityCardService
): ConcreteController<IdentityCard, IdentityCardRequest>(identityCardService){

    @GetMapping
    @HasPermission(PermissionSeed.IDENTITY_CARD_VIEW)
    @Operation(tags = ["identity-card"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    @ApiResponses(value = [ ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED) ])
    override fun findAll(@ParameterObject pageable: Pageable): ResponseEntity<Page<IdentityCard>> = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.IDENTITY_CARD_VIEW)
    @Operation(tags = ["identity-card"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String): ResponseEntity<IdentityCard> = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.IDENTITY_CARD_SAVE)
    @Operation(tags = ["identity-card"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: IdentityCardRequest): ResponseEntity<IdentityCard> = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.IDENTITY_CARD_UPDATE)
    @Operation(tags = ["identity-card"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: IdentityCardRequest, @PathVariable id: String): ResponseEntity<IdentityCard> = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.IDENTITY_CARD_DELETE)
    @Operation(tags = ["identity-card"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String): ResponseEntity<Unit> = super.deleteById(id)
}