package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.named.NamedDescriptionServiceTest
import app.com.eiduca.module.core.create.concrete.RoleCreate
import app.com.eiduca.module.core.model.concrect.Role
import app.com.eiduca.module.core.repository.concrect.RoleRepository

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of role service")
class RoleServiceTest: NamedDescriptionServiceTest<Role>() {
    @InjectMocks
    lateinit var roleService: RoleService
    @Mock
    lateinit var roleRepository: RoleRepository

    @BeforeEach
    fun setUp() {
        setUpNamedDescription(roleService, roleRepository, RoleCreate.ROLE_SAVE)
    }
}