package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionRepositoryTest
import app.com.eiduca.module.academic.create.concrete.CurriculumYearCreate
import app.com.eiduca.module.academic.model.concrete.CurriculumYear
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of curriculumYear repository")
class CurriculumYearRepositoryTest(
    @Autowired val curriculumYearRepository: CurriculumYearRepository
): OrderCodeNamedDescriptionRepositoryTest<CurriculumYear>(curriculumYearRepository, CurriculumYearCreate.CURRICULUM_YEAR_SAVE)