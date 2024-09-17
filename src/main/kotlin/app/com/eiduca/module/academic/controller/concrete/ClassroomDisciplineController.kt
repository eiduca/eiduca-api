package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline
import app.com.eiduca.module.academic.request.concrete.ClassroomDisciplineRequest
import app.com.eiduca.module.academic.service.concrete.ClassroomDisciplineService
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.seed.PermissionSeed
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiPrefix}/classroom-disciplines")
class ClassroomDisciplineController(
    classroomDisciplineService: ClassroomDisciplineService
):  ConcreteController<ClassroomDiscipline, ClassroomDisciplineRequest>(classroomDisciplineService){

    @GetMapping
    @HasPermission(PermissionSeed.CLASSROOM_DISCIPLINE_VIEW)
    @Operation(tags = ["classroom-discipline"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable) = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.CLASSROOM_DISCIPLINE_VIEW)
    @Operation(tags = ["classroom-discipline"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String) = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.CLASSROOM_DISCIPLINE_SAVE)
    @Operation(tags = ["classroom-discipline"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: ClassroomDisciplineRequest) = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.CLASSROOM_DISCIPLINE_UPDATE)
    @Operation(tags = ["classroom-discipline"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: ClassroomDisciplineRequest, @PathVariable id: String) = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.CLASSROOM_DISCIPLINE_DELETE)
    @Operation(tags = ["classroom-discipline"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String) = super.deleteById(id)
}