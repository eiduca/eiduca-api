package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.create.concrete.PermissionCreate
import app.com.eiduca.module.core.repository.concrect.PermissionRepository
import app.com.eiduca.module.core.seed.concrete.PermissionSeed
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
@DisplayName("Test of permission service")
class PermissionServiceTest {

    @InjectMocks
    lateinit var permissionService: PermissionService

    @Mock
    lateinit var permissionRepository: PermissionRepository

    @BeforeEach
    fun setUp() {
        val permission = PermissionCreate.PERMISSION_SAVE
        val permissions = PageImpl(PermissionSeed.entries.map { it.permission })
        BDDMockito.`when`(permissionRepository.findAll(Pageable.ofSize(15))).thenReturn(permissions)
        BDDMockito.`when`(permissionRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(permission))
        BDDMockito.`when`(permissionRepository.findByName(ArgumentMatchers.anyString())).thenReturn(Optional.of(permission))
        BDDMockito.`when`(permissionRepository.save(permission)).thenReturn(permission)
        BDDMockito.doNothing().`when`(permissionRepository).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of permissions when successful")
    fun findAll_WhenSuccessful() {
        val response = permissionService.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find permission by id when successful")
    fun findById_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_SAVE
        assertDoesNotThrow {
            val response = permissionService.findById(permission.id)
            assertEquals(response.id, permission.id)
        }
    }

    @Test
    @DisplayName("Find permission by username when successful")
    fun findByName_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_SAVE
        assertDoesNotThrow {
            val response = permissionService.findByName(permission.name)
            assertEquals(response.name, permission.name)
        }
    }

    @Test
    @DisplayName("Create permission when successful")
    fun save_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_SAVE
        assertDoesNotThrow {
            val response = permissionService.save(permission)
            assertNotNull(response.id)
            assertEquals(response.name, permission.name)
        }
    }

    @Test
    @DisplayName("Create or update permission when successful")
    fun saveOrUpdate_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_SAVE
        assertDoesNotThrow {
            val response = permissionService.saveOrUpdate(permission)
            assertNotNull(response.id)
            assertEquals(response.name, permission.name)
        }
    }

    @Test
    @DisplayName("Update permission when successful")
    fun update_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_UPDATE
        assertDoesNotThrow {
            val response = permissionService.update(permission)
            assertNotNull(response.id)
            assert(response == permission)
        }
    }

    @Test
    @DisplayName("Delete permission by id when successful")
    fun deleteById_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_UPDATE
        assertDoesNotThrow {
            permissionService.deleteById(permission.id)
        }
    }

}