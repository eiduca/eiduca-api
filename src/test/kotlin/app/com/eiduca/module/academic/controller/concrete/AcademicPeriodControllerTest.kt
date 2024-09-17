package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.AcademicPeriodCreate
import app.com.eiduca.module.academic.model.concrete.AcademicPeriod
import app.com.eiduca.module.academic.request.concrete.AcademicPeriodRequest
import app.com.eiduca.module.academic.service.concrete.AcademicPeriodService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of academic periods controller")
class AcademicPeriodControllerTest: ConcreteControllerTest<AcademicPeriod, AcademicPeriodRequest>() {
    @InjectMocks
    lateinit var academicPeriodController: AcademicPeriodController
    @Mock
    lateinit var academicPeriodService: AcademicPeriodService

    @BeforeEach
    fun setUp() {
        setUpConcrete(academicPeriodController, academicPeriodService, AcademicPeriodCreate.ACADEMIC_PERIOD_SAVE)
    }

    override fun createModel() = academicPeriodController.save(model.toRequest())

    override fun updateModel() = academicPeriodController.update(model.toRequest(), model.id)
}