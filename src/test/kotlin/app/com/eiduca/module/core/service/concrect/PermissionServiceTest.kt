package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.ConcreteServiceTest
import app.com.eiduca.module.core.create.concrete.PermissionCreate
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.repository.concrect.PermissionRepository
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
@DisplayName("Test of permission service")
class PermissionServiceTest: ConcreteServiceTest<Permission>() {

    @InjectMocks
    lateinit var permissionService: PermissionService

    @Mock
    lateinit var permissionRepository: PermissionRepository

    @BeforeEach
    fun setUp() {
        setUpConcrete(permissionService, permissionRepository, PermissionCreate.PERMISSION_SAVE)
        BDDMockito.`when`(permissionRepository.findByName(model.name)).thenReturn(Optional.of(model))
        BDDMockito.`when`(permissionRepository.findByDescription(model.description)).thenReturn(Optional.of(model))
    }

    @Test
    @DisplayName("Find permission by name when successful")
    fun findByName_WhenSuccessful() {
        assertDoesNotThrow {
            val response = permissionService.findByName(model.name)
            assertEquals(response.name, model.name)
        }
    }

    @Test
    @DisplayName("Find permission by description when successful")
    fun findByDescription_WhenSuccessful() {
        assertDoesNotThrow {
            val response = permissionService.findByDescription(model.description)
            assertEquals(response.description, model.description)
        }
    }

    @Test
    @DisplayName("Create or update permission when successful")
    fun saveOrUpdate_WhenSuccessful() {
        assertDoesNotThrow {
            val response = permissionService.saveOrUpdate(model)
            assertNotNull(response.id)
            assertEquals(response.name, model.name)
        }
    }
}