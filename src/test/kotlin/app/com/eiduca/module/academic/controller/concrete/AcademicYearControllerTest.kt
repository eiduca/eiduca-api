package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.AcademicYearCreate
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import app.com.eiduca.module.academic.request.concrete.AcademicYearRequest
import app.com.eiduca.module.academic.service.concrete.AcademicYearService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of academicYear controller")
class AcademicYearControllerTest: ConcreteControllerTest<AcademicYear, AcademicYearRequest>() {
    @InjectMocks
    lateinit var academicYearController: AcademicYearController
    @Mock
    lateinit var academicYearService: AcademicYearService

    @BeforeEach
    fun setUp() {
        setUpConcrete(academicYearController, academicYearService, AcademicYearCreate.ACADEMIC_YEAR_SAVE)
    }

    override fun createModel(): ResponseEntity<AcademicYear> = academicYearController.save(model.toRequest())

    override fun updateModel(): ResponseEntity<AcademicYear> = academicYearController.update(model.toRequest(), model.id)
}