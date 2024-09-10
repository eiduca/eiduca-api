package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.configuration.annotation.HasPermission
import app.com.eiduca.configuration.constant.ProjectConst
import app.com.eiduca.module.core.common.general.ConcreteController
import app.com.eiduca.module.core.constant.MessageDoc
import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.request.PersonRequest
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.module.core.service.concrect.PersonService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(ProjectConst.CROSS_ORIGIN)
@RequestMapping("\${apiPrefix}/persons")
class PersonController(
    val personService: PersonService,
): ConcreteController<Person, PersonRequest>(personService) {

    @GetMapping
    @HasPermission(PermissionSeed.PERSON_VIEW)
    @Operation(tags = ["person"], summary = MessageDoc.SUMMARY_FIND_ALL, description = MessageDoc.DESCRIPTION_FIND_ALL)
    @ApiResponses(value = [ ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED) ])
    override fun findAll(@ParameterObject pageable: Pageable): ResponseEntity<Page<Person>> {
        return ResponseEntity(personService.findAll(pageable), ReturnStatus.OK)
    }

    @GetMapping("/{id}")
    @HasPermission(PermissionSeed.PERSON_VIEW)
    @Operation(tags = ["person"], summary = MessageDoc.SUMMARY_FIND_BY_ID, description = MessageDoc.DESCRIPTION_FIND_BY_ID)
    @ApiResponses(value = [
        ApiResponse(responseCode = MessageDoc.STATUS_NOT_FOUND, description = MessageDoc.NOT_FOUND),
        ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED)
    ])
    override fun findById(@PathVariable id: String): ResponseEntity<Person> {
        return ResponseEntity(personService.findById(id), ReturnStatus.OK)
    }

    @Transactional
    @PostMapping
    @HasPermission(PermissionSeed.PERSON_SAVE)
    @Operation(tags = ["person"], summary = MessageDoc.SUMMARY_SAVE, description = MessageDoc.DESCRIPTION_SAVE)
    @ApiResponses(value = [
        ApiResponse(responseCode = MessageDoc.STATUS_CREATED, description = MessageDoc.CREATED),
        ApiResponse(responseCode = MessageDoc.STATUS_FAILED, description = MessageDoc.FAILED),
        ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED)
    ])
    override fun save(@Valid @RequestBody request: PersonRequest): ResponseEntity<Person>{
        return ResponseEntity(personService.save(request.toModel()), ReturnStatus.CREATED)
    }

    @Transactional
    @PutMapping("/{id}")
    @HasPermission(PermissionSeed.PERSON_UPDATE)
    @Operation(tags = ["person"], summary = MessageDoc.SUMMARY_UPDATE, description = MessageDoc.DESCRIPTION_UPDATE)
    @ApiResponses(value = [
        ApiResponse(responseCode = MessageDoc.STATUS_UPDATE, description = MessageDoc.UPDATE),
        ApiResponse(responseCode = MessageDoc.STATUS_FAILED, description = MessageDoc.FAILED),
        ApiResponse(responseCode = MessageDoc.STATUS_NOT_FOUND, description = MessageDoc.NOT_FOUND),
        ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED)
    ])
    override fun update(@Valid @RequestBody request: PersonRequest, @PathVariable id: String): ResponseEntity<Person> {
        return ResponseEntity(personService.update(request.toModel(), id), ReturnStatus.UPDATED)
    }

    @Transactional
    @DeleteMapping("/{id}")
    @HasPermission(PermissionSeed.PERSON_DELETE)
    @Operation(tags = ["person"], summary = MessageDoc.SUMMARY_DELETE, description = MessageDoc.DESCRIPTION_DELETE)
    @ApiResponses(value = [
        ApiResponse(responseCode = MessageDoc.STATUS_DELETED, description = MessageDoc.DELETED),
        ApiResponse(responseCode = MessageDoc.STATUS_NOT_FOUND, description = MessageDoc.NOT_FOUND),
        ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED)
    ])
    override fun deleteById(@PathVariable id: String): ResponseEntity<Unit> {
        return ResponseEntity(personService.deleteById(id), ReturnStatus.DELETED)
    }
}