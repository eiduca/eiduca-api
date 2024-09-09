package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.ConcreteServiceTest
import app.com.eiduca.module.core.create.concrete.RoleCreate
import app.com.eiduca.module.core.model.concrect.Role
import app.com.eiduca.module.core.repository.concrect.RoleRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@ExtendWith(SpringExtension::class)
@DisplayName("Test of role service")
class RoleServiceTest: ConcreteServiceTest<Role>() {

    @InjectMocks
    lateinit var roleService: RoleService

    @Mock
    lateinit var roleRepository: RoleRepository

    @BeforeEach
    fun setUp() {
        setUpConcrete(roleService, roleRepository, RoleCreate.ROLE_SAVE)
        BDDMockito.`when`(roleRepository.findByName(model.name)).thenReturn(Optional.of(model))
        BDDMockito.`when`(roleRepository.findByDescription(model.description)).thenReturn(Optional.of(model))
    }

    @Test
    @DisplayName("Find role by username when successful")
    fun findByName_WhenSuccessful() {
        assertDoesNotThrow {
            val response = roleService.findByName(model.name)
            assertEquals(response.name, model.name)
        }
    }

    @Test
    @DisplayName("Find permission by description when successful")
    fun findByDescription_WhenSuccessful() {
        assertDoesNotThrow {
            val response = roleService.findByDescription(model.description)
            assertEquals(response.description, model.description)
        }
    }

    @Test
    @DisplayName("Create or update role when successful")
    fun saveOrUpdate_WhenSuccessful() {
        assertDoesNotThrow {
            val response = roleService.saveOrUpdate(model)
            assertNotNull(response.id)
            assertEquals(response.name, model.name)
        }
    }

}