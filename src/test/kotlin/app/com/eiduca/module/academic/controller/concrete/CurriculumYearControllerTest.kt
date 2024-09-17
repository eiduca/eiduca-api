package app.com.eiduca.module.academic.controller.concrete

import app.com.eiduca.module.academic.create.concrete.CurriculumYearCreate
import app.com.eiduca.module.academic.model.concrete.CurriculumYear
import app.com.eiduca.module.academic.request.concrete.CurriculumYearRequest
import app.com.eiduca.module.academic.service.concrete.CurriculumYearService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of curriculum years controller")
class CurriculumYearControllerTest: ConcreteControllerTest<CurriculumYear, CurriculumYearRequest>() {
    @InjectMocks
    lateinit var curriculumYearController: CurriculumYearController
    @Mock
    lateinit var curriculumYearService: CurriculumYearService

    @BeforeEach
    fun setUp() {
        setUpConcrete(curriculumYearController, curriculumYearService, CurriculumYearCreate.CURRICULUM_YEAR_SAVE)
    }

    override fun createModel() = curriculumYearController.save(model.toRequest())

    override fun updateModel() = curriculumYearController.update(model.toRequest(), model.id)
}