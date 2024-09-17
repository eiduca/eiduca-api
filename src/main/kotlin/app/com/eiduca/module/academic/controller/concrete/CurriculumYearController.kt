package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.academic.model.concrete.CurriculumYear
import app.com.eiduca.module.academic.request.concrete.CurriculumYearRequest
import app.com.eiduca.module.academic.service.concrete.CurriculumYearService
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.seed.PermissionSeed
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Pageable
import org.springdoc.core.annotations.ParameterObject
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid

@RestController
@RequestMapping("\${apiPrefix}/curriculum-years")
class CurriculumYearController(
    curriculumYearService: CurriculumYearService
): ConcreteController<CurriculumYear, CurriculumYearRequest>(curriculumYearService) {
    @GetMapping
    @HasPermission(PermissionSeed.CURRICULUM_YEAR_VIEW)
    @Operation(tags = ["curriculum-year"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable) = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.CURRICULUM_YEAR_VIEW)
    @Operation(tags = ["curriculum-year"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String) = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.CURRICULUM_YEAR_SAVE)
    @Operation(tags = ["curriculum-year"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: CurriculumYearRequest) = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.CURRICULUM_YEAR_UPDATE)
    @Operation(tags = ["curriculum-year"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: CurriculumYearRequest, @PathVariable id: String) = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.CURRICULUM_YEAR_DELETE)
    @Operation(tags = ["curriculum-year"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String) = super.deleteById(id)
}