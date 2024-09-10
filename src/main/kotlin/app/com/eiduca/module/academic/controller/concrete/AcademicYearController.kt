package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.academic.request.concrete.AcademicYearRequest
import app.com.eiduca.module.academic.service.concrete.AcademicYearService
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
@RequestMapping("\${apiPrefix}/academic-years")
class AcademicYearController(
    academicYearService: AcademicYearService
): ConcreteController<AcademicYear, AcademicYearRequest>(academicYearService) {

    @GetMapping
    @HasPermission(PermissionSeed.ACADEMIC_YEAR_VIEW)
    @Operation(tags = ["academic-year"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable): ResponseEntity<Page<AcademicYear>> = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.ACADEMIC_YEAR_VIEW)
    @Operation(tags = ["academic-year"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String): ResponseEntity<AcademicYear> = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.ACADEMIC_YEAR_SAVE)
    @Operation(tags = ["academic-year"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: AcademicYearRequest): ResponseEntity<AcademicYear> = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.ACADEMIC_YEAR_UPDATE)
    @Operation(tags = ["academic-year"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: AcademicYearRequest, @PathVariable id: String): ResponseEntity<AcademicYear> = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.ACADEMIC_YEAR_DELETE)
    @Operation(tags = ["academic-year"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String): ResponseEntity<Unit> = super.deleteById(id)
}