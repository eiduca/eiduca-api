package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.request.concrete.AcademicYearRequest
import app.com.eiduca.module.academic.service.concrete.AcademicYearService
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.configuration.annotation.HasPermission
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid

@RestController
@RequestMapping("\${apiPrefix}/academic-years")
class AcademicYearController(
    academicYearService: AcademicYearService
): ConcreteController<AcademicYear, AcademicYearRequest>(academicYearService) {

    @GetMapping
    @HasPermission(PermissionSeed.ACADEMIC_YEAR_VIEW)
    @Operation(tags = ["academic-year"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable) = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.ACADEMIC_YEAR_VIEW)
    @Operation(tags = ["academic-year"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String) = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.ACADEMIC_YEAR_SAVE)
    @Operation(tags = ["academic-year"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: AcademicYearRequest) = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.ACADEMIC_YEAR_UPDATE)
    @Operation(tags = ["academic-year"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: AcademicYearRequest, @PathVariable id: String) = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.ACADEMIC_YEAR_DELETE)
    @Operation(tags = ["academic-year"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String) = super.deleteById(id)
}