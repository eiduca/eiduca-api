package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionRepositoryTest
import app.com.eiduca.module.academic.create.concrete.DisciplineCreate
import app.com.eiduca.module.academic.model.concrete.Discipline
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of discipline repository")
class DisciplineRepositoryTest(
    @Autowired val disciplineRepository: DisciplineRepository
): CodeNamedDescriptionRepositoryTest<Discipline>(disciplineRepository, DisciplineCreate.DISCIPLINE_SAVE)