package app.com.eiduca.module.core.controller.pivot

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.core.common.general.PivotController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.model.pivot.PersonAddress
import app.com.eiduca.module.core.request.PersonAddressRequest
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.module.core.service.pivot.PersonAddressService
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid

@RestController
@RequestMapping("\${apiPrefix}/person-address")
class PersonAddressController(
    personAddressService: PersonAddressService
): PivotController<PersonAddress, PersonAddressRequest>(personAddressService) {

    @GetMapping
    @HasPermission(PermissionSeed.PERSON_ADDRESS_VIEW)
    @Operation(tags = ["person-address"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable) = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.PERSON_ADDRESS_VIEW)
    @Operation(tags = ["person-address"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String) = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.PERSON_ADDRESS_SAVE)
    @Operation(tags = ["person-address"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: PersonAddressRequest) = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.PERSON_ADDRESS_UPDATE)
    @Operation(tags = ["person-address"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: PersonAddressRequest, @PathVariable id: String) = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.PERSON_ADDRESS_DELETE)
    @Operation(tags = ["person-address"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String) = super.deleteById(id)
}