package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.request.concrete.DisciplineRequest
import app.com.eiduca.module.academic.service.concrete.DisciplineService
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.seed.PermissionSeed
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid

@RestController
@RequestMapping("\${apiPrefix}/disciplines")
class DisciplineController(
    disciplineService: DisciplineService
): ConcreteController<Discipline, DisciplineRequest>(disciplineService) {
    @GetMapping
    @HasPermission(PermissionSeed.DISCIPLINE_VIEW)
    @Operation(tags = ["discipline"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable) = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.DISCIPLINE_VIEW)
    @Operation(tags = ["discipline"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String) = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.DISCIPLINE_SAVE)
    @Operation(tags = ["discipline"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: DisciplineRequest) = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.DISCIPLINE_UPDATE)
    @Operation(tags = ["discipline"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: DisciplineRequest, @PathVariable id: String) = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.DISCIPLINE_DELETE)
    @Operation(tags = ["discipline"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String) = super.deleteById(id)
}