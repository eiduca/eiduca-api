package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.UniversityCreate
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.academic.request.concrete.UniversityRequest
import app.com.eiduca.module.academic.service.concrete.UniversityService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of university controller")
class UniversityControllerTest: ConcreteControllerTest<University, UniversityRequest>() {
    @InjectMocks
    lateinit var universityController: UniversityController
    @Mock
    lateinit var universityService: UniversityService

    @BeforeEach
    fun setUp() {
        setUpConcrete(universityController, universityService, UniversityCreate.UNIVERSITY_SAVE)
    }

    override fun createModel(): ResponseEntity<University> = universityController.save(model.toRequest())

    override fun updateModel(): ResponseEntity<University> = universityController.update(model.toRequest(), model.id)
}