package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.InstitutionCreate
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.request.concrete.InstitutionRequest
import app.com.eiduca.module.academic.service.concrete.InstitutionService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of institution controller")
class InstitutionControllerTest: ConcreteControllerTest<Institution, InstitutionRequest>() {
    @InjectMocks
    lateinit var institutionController: InstitutionController
    @Mock
    lateinit var institutionService: InstitutionService

    @BeforeEach
    fun setUp() {
        setUpConcrete(institutionController, institutionService, InstitutionCreate.INSTITUTION_SAVE)
    }

    override fun createModel(): ResponseEntity<Institution> = institutionController.save(model.toRequest())

    override fun updateModel(): ResponseEntity<Institution> = institutionController.update(model.toRequest(), model.id)
}