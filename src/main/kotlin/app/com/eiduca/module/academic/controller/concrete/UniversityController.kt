package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.academic.request.concrete.UniversityRequest
import app.com.eiduca.module.academic.service.concrete.UniversityService
import app.com.eiduca.module.core.common.general.ConcreteController
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
@RequestMapping("\${apiPrefix}/universities")
class UniversityController(
    universityService: UniversityService
): ConcreteController<University, UniversityRequest>(universityService) {

    @GetMapping
    @HasPermission(PermissionSeed.UNIVERSITY_VIEW)
    @Operation(tags = ["university"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable): ResponseEntity<Page<University>> = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.UNIVERSITY_VIEW)
    @Operation(tags = ["university"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String): ResponseEntity<University> = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.UNIVERSITY_SAVE)
    @Operation(tags = ["university"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: UniversityRequest): ResponseEntity<University> = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.UNIVERSITY_UPDATE)
    @Operation(tags = ["university"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: UniversityRequest, @PathVariable id: String): ResponseEntity<University> = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.UNIVERSITY_DELETE)
    @Operation(tags = ["university"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String): ResponseEntity<Unit>  = super.deleteById(id)
}