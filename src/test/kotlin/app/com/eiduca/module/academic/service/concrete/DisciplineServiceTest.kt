package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionServiceTest
import app.com.eiduca.module.academic.create.concrete.DisciplineCreate
import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.academic.repository.concrete.DisciplineRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of discipline service")
class DisciplineServiceTest: CodeNamedDescriptionServiceTest<Discipline>(){
    @InjectMocks
    lateinit var disciplineService: DisciplineService
    @Mock
    lateinit var disciplineRepository: DisciplineRepository

    @BeforeEach
    fun setUpDiscipline() {
        setUpCodeNamedDescription(disciplineService, disciplineRepository, DisciplineCreate.DISCIPLINE_SAVE)
    }
}