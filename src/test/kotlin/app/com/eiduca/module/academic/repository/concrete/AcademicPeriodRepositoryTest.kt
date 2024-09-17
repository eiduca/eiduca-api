package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionRepositoryTest
import app.com.eiduca.module.academic.create.concrete.AcademicPeriodCreate
import app.com.eiduca.module.academic.model.concrete.AcademicPeriod
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.beans.factory.annotation.Autowired
import org.junit.jupiter.api.DisplayName

@DataJpaTest
@DisplayName("Test of academic periods repository")
class AcademicPeriodRepositoryTest(
    @Autowired val academicPeriodRepository: AcademicPeriodRepository
): OrderCodeNamedDescriptionRepositoryTest<AcademicPeriod>(academicPeriodRepository, AcademicPeriodCreate.ACADEMIC_PERIOD_SAVE)