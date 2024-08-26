package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.create.concrete.RoleCreate
import app.com.eiduca.module.core.repository.concrect.RoleRepository
import app.com.eiduca.module.core.seed.concrete.RoleSeed
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@ExtendWith(SpringExtension::class)
@DisplayName("Test of role service")
class RoleServiceTest {

    @InjectMocks
    lateinit var roleService: RoleService

    @Mock
    lateinit var roleRepository: RoleRepository

    @BeforeEach
    fun setUp() {
        val role = RoleCreate.ROLE_SAVE
        val roles = PageImpl(RoleSeed.entries.map { it.role })
        BDDMockito.`when`(roleRepository.findAll(Pageable.ofSize(15))).thenReturn(roles)
        BDDMockito.`when`(roleRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(role))
        BDDMockito.`when`(roleRepository.findByName(ArgumentMatchers.anyString())).thenReturn(Optional.of(role))
        BDDMockito.`when`(roleRepository.save(role)).thenReturn(role)
        BDDMockito.doNothing().`when`(roleRepository).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of roles when successful")
    fun findAll_WhenSuccessful() {
        val response = roleService.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find role by id when successful")
    fun findById_WhenSuccessful() {
        val role = RoleCreate.ROLE_SAVE
        assertDoesNotThrow {
            val response = roleService.findById(role.id)
            assertEquals(response.id, role.id)
        }
    }

    @Test
    @DisplayName("Find role by username when successful")
    fun findByName_WhenSuccessful() {
        val role = RoleCreate.ROLE_SAVE
        assertDoesNotThrow {
            val response = roleService.findByName(role.name)
            assertEquals(response.name, role.name)
        }
    }

    @Test
    @DisplayName("Create role when successful")
    fun save_WhenSuccessful() {
        val role = RoleCreate.ROLE_SAVE
        assertDoesNotThrow {
            val response = roleService.save(role)
            assertNotNull(response.id)
            assertEquals(response.name, role.name)
        }
    }

    @Test
    @DisplayName("Create or update role when successful")
    fun saveOrUpdate_WhenSuccessful() {
        val role = RoleCreate.ROLE_UPDATE
        assertDoesNotThrow {
            val response = roleService.saveOrUpdate(role)
            assertNotNull(response.id)
            assertEquals(response.name, role.name)
        }
    }

    @Test
    @DisplayName("Update role when successful")
    fun update_WhenSuccessful() {
        val role = RoleCreate.ROLE_UPDATE
        assertDoesNotThrow {
            val response = roleService.update(role)
            assertNotNull(response.id)
            assert(response == role)
        }
    }

    @Test
    @DisplayName("Delete role by id when successful")
    fun deleteById_WhenSuccessful() {
        val role = RoleCreate.ROLE_UPDATE
        assertDoesNotThrow {
            roleService.deleteById(role.id)
        }
    }

}