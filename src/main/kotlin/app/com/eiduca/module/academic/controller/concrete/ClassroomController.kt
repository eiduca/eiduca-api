package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.module.academic.request.concrete.ClassroomRequest
import app.com.eiduca.module.academic.service.concrete.ClassroomService
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.seed.PermissionSeed
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Pageable
import org.springdoc.core.annotations.ParameterObject
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid

@RestController
@RequestMapping("\${apiPrefix}/classrooms")
class ClassroomController(
    classroomService: ClassroomService
): ConcreteController<Classroom, ClassroomRequest>(classroomService) {
    @GetMapping
    @HasPermission(PermissionSeed.CLASSROOM_VIEW)
    @Operation(tags = ["classroom"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable) = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.CLASSROOM_VIEW)
    @Operation(tags = ["classroom"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String) = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.CLASSROOM_SAVE)
    @Operation(tags = ["classroom"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: ClassroomRequest) = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.CLASSROOM_UPDATE)
    @Operation(tags = ["classroom"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: ClassroomRequest, @PathVariable id: String) = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.CLASSROOM_DELETE)
    @Operation(tags = ["classroom"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String) = super.deleteById(id)
}