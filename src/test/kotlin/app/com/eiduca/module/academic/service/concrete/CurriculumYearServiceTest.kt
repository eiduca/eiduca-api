package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionServiceTest
import app.com.eiduca.module.academic.create.concrete.CurriculumYearCreate
import app.com.eiduca.module.academic.model.concrete.CurriculumYear
import app.com.eiduca.module.academic.repository.concrete.CurriculumYearRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of curriculum years service")
class CurriculumYearServiceTest: OrderCodeNamedDescriptionServiceTest<CurriculumYear>(){
    @InjectMocks
    lateinit var curriculumYearService: CurriculumYearService
    @Mock
    lateinit var curriculumYearRepository: CurriculumYearRepository

    @BeforeEach
    fun setUp() {
        setUpOrderCodeNamedDescription(curriculumYearService, curriculumYearRepository, CurriculumYearCreate.CURRICULUM_YEAR_SAVE)
    }
}