package app.com.eiduca.module.academic.controller.pivot

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.academic.request.pivot.UniversityAddressRequest
import app.com.eiduca.module.academic.service.pivot.UniversityAddressService
import app.com.eiduca.module.core.common.general.PivotController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.seed.PermissionSeed
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiPrefix}/university-address")
class UniversityAddressController(
    val universityAddressService: UniversityAddressService
): PivotController<UniversityAddress, UniversityAddressRequest>(universityAddressService) {

    @GetMapping
    @HasPermission(PermissionSeed.UNIVERSITY_ADDRESS_VIEW)
    @Operation(tags = ["university-address"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable): ResponseEntity<Page<UniversityAddress>> = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.UNIVERSITY_ADDRESS_VIEW)
    @Operation(tags = ["university-address"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String): ResponseEntity<UniversityAddress> = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.UNIVERSITY_ADDRESS_SAVE)
    @Operation(tags = ["university-address"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: UniversityAddressRequest): ResponseEntity<UniversityAddress> = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.UNIVERSITY_ADDRESS_UPDATE)
    @Operation(tags = ["university-address"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: UniversityAddressRequest, @PathVariable id: String): ResponseEntity<UniversityAddress>  = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.UNIVERSITY_ADDRESS_DELETE)
    @Operation(tags = ["university-address"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String): ResponseEntity<Unit> = super.deleteById(id)
}