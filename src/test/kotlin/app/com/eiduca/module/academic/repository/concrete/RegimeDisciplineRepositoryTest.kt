package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionRepositoryTest
import app.com.eiduca.module.academic.create.concrete.RegimeDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of regime of discipline repository")
class RegimeDisciplineRepositoryTest(
    @Autowired val regimeDisciplineRepository: RegimeDisciplineRepository
): CodeNamedDescriptionRepositoryTest<RegimeDiscipline>(regimeDisciplineRepository, RegimeDisciplineCreate.REGIME_DISCIPLINE_SAVE)