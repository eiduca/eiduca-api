package app.com.eiduca.module.candidacy.controller.concrete

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.module.candidacy.request.concrete.CandidateRequest
import app.com.eiduca.module.candidacy.service.CandidateService
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.seed.PermissionSeed
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${apiPrefix}/candidates")
class CandidateController(
    candidateService: CandidateService
): ConcreteController<Candidate, CandidateRequest>(candidateService) {

    @GetMapping
    @HasPermission(PermissionSeed.CANDIDATE_VIEW)
    @Operation(tags = ["candidate"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    override fun findAll(@ParameterObject pageable: Pageable) = super.findAll(pageable)

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.CANDIDATE_VIEW)
    @Operation(tags = ["candidate"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    override fun findById(@PathVariable id: String) = super.findById(id)

    @PostMapping
    @HasPermission(PermissionSeed.CANDIDATE_SAVE)
    @Operation(tags = ["candidate"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    override fun save(@Valid @RequestBody request: CandidateRequest) = super.save(request)

    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.CANDIDATE_UPDATE)
    @Operation(tags = ["candidate"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    override fun update(@Valid @RequestBody request: CandidateRequest, @PathVariable id: String) = super.update(request, id)

    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.CANDIDATE_DELETE)
    @Operation(tags = ["candidate"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    override fun deleteById(@PathVariable id: String) = super.deleteById(id)
}