package app.com.eiduca.module.academic.controller.pivot

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.configuration.constant.ProjectConst
import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.academic.request.pivot.UniversityAddressRequest
import app.com.eiduca.module.academic.service.pivot.UniversityAddressService
import app.com.eiduca.module.core.common.general.PivotController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.seed.PermissionSeed
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(ProjectConst.CROSS_ORIGIN)
@RequestMapping("\${apiPrefix}/university-address")
class UniversityAddressController(
    val universityAddressService: UniversityAddressService
): PivotController<UniversityAddress, UniversityAddressRequest>(universityAddressService) {

    @GetMapping
    @HasPermission(PermissionSeed.UNIVERSITY_ADDRESS_VIEW)
    @Operation(tags = ["university-address"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    @ApiResponses(value = [ ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED) ])
    override fun findAll(@ParameterObject pageable: Pageable): ResponseEntity<Page<UniversityAddress>> {
        return ResponseEntity(universityAddressService.findAll(pageable), ReturnStatus.OK)
    }

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.UNIVERSITY_ADDRESS_VIEW)
    @Operation(tags = ["university-address"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    @ApiResponses(value = [ ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED) ])
    override fun findById(@PathVariable id: String): ResponseEntity<UniversityAddress> {
        return ResponseEntity(universityAddressService.findById(id), ReturnStatus.OK)
    }

    @Transactional
    @PostMapping
    @HasPermission(PermissionSeed.UNIVERSITY_ADDRESS_SAVE)
    @Operation(tags = ["university-address"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    @ApiResponses(value = [
        ApiResponse(responseCode = MessageDoc.STATUS_CREATED, description = MessageDoc.CREATED),
        ApiResponse(responseCode = MessageDoc.STATUS_FAILED, description = MessageDoc.FAILED),
        ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED)
    ])
    override fun save(@Valid @RequestBody request: UniversityAddressRequest): ResponseEntity<UniversityAddress> {
        return ResponseEntity(universityAddressService.save(request.toModel()), ReturnStatus.CREATED)
    }

    @Transactional
    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.UNIVERSITY_ADDRESS_UPDATE)
    @Operation(tags = ["university-address"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    @ApiResponses(value = [
        ApiResponse(responseCode = MessageDoc.STATUS_UPDATE, description = MessageDoc.UPDATE),
        ApiResponse(responseCode = MessageDoc.STATUS_FAILED, description = MessageDoc.FAILED),
        ApiResponse(responseCode = MessageDoc.STATUS_NOT_FOUND, description = MessageDoc.NOT_FOUND),
        ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED)
    ])
    override fun update(@Valid @RequestBody request: UniversityAddressRequest, @PathVariable id: String): ResponseEntity<UniversityAddress> {
        return ResponseEntity(universityAddressService.update(request.toModel(),id), ReturnStatus.UPDATED)
    }

    @Transactional
    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.UNIVERSITY_ADDRESS_DELETE)
    @Operation(tags = ["university-address"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    @ApiResponses(value = [
        ApiResponse(responseCode = MessageDoc.STATUS_DELETED, description = MessageDoc.DELETED),
        ApiResponse(responseCode = MessageDoc.STATUS_NOT_FOUND, description = MessageDoc.NOT_FOUND),
        ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED)
    ])
    override fun deleteById(@PathVariable id: String): ResponseEntity<Unit> {
        return ResponseEntity(universityAddressService.deleteById(id), ReturnStatus.DELETED)
    }
}