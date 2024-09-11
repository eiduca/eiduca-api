package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.named.NamedDescriptionRepositoryTest
import app.com.eiduca.module.core.create.concrete.RoleCreate
import app.com.eiduca.module.core.model.concrect.Role
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of role repository")
class RoleRepositoryTest(
    @Autowired val roleRepository: RoleRepository
): NamedDescriptionRepositoryTest<Role>(
    roleRepository, RoleCreate.ROLE_SAVE
)