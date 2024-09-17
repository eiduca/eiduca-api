package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionRepositoryTest
import app.com.eiduca.module.academic.create.concrete.ProfileDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of profile of discipline repository")
class ProfileDisciplineRepositoryTest(
    @Autowired val profileDisciplineRepository: ProfileDisciplineRepository
): CodeNamedDescriptionRepositoryTest<ProfileDiscipline>(profileDisciplineRepository, ProfileDisciplineCreate.PROFILE_DISCIPLINE_SAVE)