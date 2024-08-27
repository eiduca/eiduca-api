package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.core.common.ConcreteController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.request.body.AddressRequest
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.module.core.service.concrect.AddressService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
@RequestMapping("\${apiPrefix}/addresses")
class AddressController(
    val addressService: AddressService
): ConcreteController() {

    @GetMapping
    @HasPermission(PermissionSeed.ADDRESS_VIEW)
    @Operation(tags = ["address"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    @ApiResponses(value = [ ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED) ])
    fun findAll(@ParameterObject pageable: Pageable): ResponseEntity<Page<Address>> {
        return ResponseEntity(addressService.findAll(pageable), ReturnStatus.OK)
    }

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.ADDRESS_VIEW)
    @Operation(tags = ["address"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    @ApiResponses(value = [ ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED) ])
    fun findById(@PathVariable id: String): ResponseEntity<Address> {
        return ResponseEntity(addressService.findById(id), ReturnStatus.OK)
    }

    @Transactional
    @PostMapping
    @HasPermission(PermissionSeed.ADDRESS_SAVE)
    @Operation(tags = ["address"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    @ApiResponses(value = [
        ApiResponse(responseCode = MessageDoc.STATUS_CREATED, description = MessageDoc.CREATED),
        ApiResponse(responseCode = MessageDoc.STATUS_FAILED, description = MessageDoc.FAILED),
        ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED)
    ])
    fun save(@Valid @RequestBody addressRequest: AddressRequest): ResponseEntity<Address> {
        return ResponseEntity(addressService.save(addressRequest.toAddress()), ReturnStatus.CREATED)
    }

    @Transactional
    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.ADDRESS_UPDATE)
    @Operation(tags = ["address"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    @ApiResponses(value = [
        ApiResponse(responseCode = MessageDoc.STATUS_UPDATE, description = MessageDoc.UPDATE),
        ApiResponse(responseCode = MessageDoc.STATUS_FAILED, description = MessageDoc.FAILED),
        ApiResponse(responseCode = MessageDoc.STATUS_NOT_FOUND, description = MessageDoc.NOT_FOUND),
        ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED)
    ])
    fun update(@Valid @RequestBody addressRequest: AddressRequest, @PathVariable id: String): ResponseEntity<Address> {
        return ResponseEntity(addressService.update(addressRequest.toAddress(),id), ReturnStatus.UPDATED)
    }

    @Transactional
    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.ADDRESS_DELETE)
    @Operation(tags = ["address"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    @ApiResponses(value = [
        ApiResponse(responseCode = MessageDoc.STATUS_DELETED, description = MessageDoc.DELETED),
        ApiResponse(responseCode = MessageDoc.STATUS_NOT_FOUND, description = MessageDoc.NOT_FOUND),
        ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED)
    ])
    fun deleteById(@PathVariable id: String): ResponseEntity<Unit> {
        return ResponseEntity(addressService.deleteById(id), ReturnStatus.DELETED)
    }
}