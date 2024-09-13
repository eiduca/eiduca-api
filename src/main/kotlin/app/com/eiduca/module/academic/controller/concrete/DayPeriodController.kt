package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.request.concrete.DayPeriodRequest
import app.com.eiduca.module.academic.service.concrete.DayPeriodService
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.academic.model.concrete.DayPeriod
import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.seed.PermissionSeed
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Pageable
import org.springdoc.core.annotations.ParameterObject
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid

@RestController
@RequestMapping("\${apiPrefix}/day-periods")
class DayPeriodController(
    dayPeriodService: DayPeriodService
): ConcreteController<DayPeriod, DayPeriodRequest>(dayPeriodService) {
    @GetMapping
    @HasPermission(PermissionSeed.DAY_PERIOD_VIEW)
    @Operation(tags = ["day-period"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable) = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.DAY_PERIOD_VIEW)
    @Operation(tags = ["day-period"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String) = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.DAY_PERIOD_SAVE)
    @Operation(tags = ["day-period"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: DayPeriodRequest) = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.DAY_PERIOD_UPDATE)
    @Operation(tags = ["day-period"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: DayPeriodRequest, @PathVariable id: String) = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.DAY_PERIOD_DELETE)
    @Operation(tags = ["day-period"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String) = super.deleteById(id)
}