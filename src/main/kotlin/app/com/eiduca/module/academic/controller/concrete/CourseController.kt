package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.request.concrete.CourseRequest
import app.com.eiduca.module.academic.service.concrete.CourseService
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.configuration.annotation.HasPermission
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid

@RestController
@RequestMapping("\${apiPrefix}/courses")
class CourseController(
    courseService: CourseService
): ConcreteController<Course, CourseRequest>(courseService) {

    @GetMapping
    @HasPermission(PermissionSeed.COURSE_VIEW)
    @Operation(tags = ["course"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable) = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.COURSE_VIEW)
    @Operation(tags = ["course"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String) = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.COURSE_SAVE)
    @Operation(tags = ["course"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: CourseRequest) = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.COURSE_UPDATE)
    @Operation(tags = ["course"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: CourseRequest, @PathVariable id: String) = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.COURSE_DELETE)
    @Operation(tags = ["course"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String) = super.deleteById(id)
}