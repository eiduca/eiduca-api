package app.com.eiduca.module.candidacy.controller.concrete

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.candidacy.model.AccessExam
import app.com.eiduca.module.candidacy.request.concrete.AccessExamRequest
import app.com.eiduca.module.candidacy.service.AccessExamService
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.seed.PermissionSeed
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiPrefix}/access-exams")
class AccessExamController(
    accessExamService: AccessExamService
): ConcreteController<AccessExam, AccessExamRequest>(accessExamService) {

    @GetMapping
    @HasPermission(PermissionSeed.ACCESS_EXAM_VIEW)
    @Operation(tags = ["access-exam"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable) = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.ACCESS_EXAM_VIEW)
    @Operation(tags = ["access-exam"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String) = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.ACCESS_EXAM_SAVE)
    @Operation(tags = ["access-exam"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: AccessExamRequest) = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.ACCESS_EXAM_UPDATE)
    @Operation(tags = ["access-exam"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: AccessExamRequest, @PathVariable id: String) = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.ACCESS_EXAM_DELETE)
    @Operation(tags = ["access-exam"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String) = super.deleteById(id)
}