package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.concrete.PermissionCreate
import app.com.eiduca.module.core.seed.PermissionSeed
import app.com.eiduca.module.core.service.concrect.PermissionService
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of permission controller")
class PermissionControllerTest {

    @InjectMocks
    lateinit var permissionController: PermissionController

    @Mock
    lateinit var permissionService: PermissionService

    @BeforeEach
    fun setUp() {
        val permission = PermissionCreate.PERMISSION_SAVE
        val permissions = PageImpl(PermissionSeed.entries.map { it.permission })
        BDDMockito.`when`(permissionService.findAll(Pageable.ofSize(15))).thenReturn(permissions)
        BDDMockito.`when`(permissionService.findById(ArgumentMatchers.anyString())).thenReturn(permission)
        BDDMockito.`when`(permissionService.save(permission)).thenReturn(permission)
        BDDMockito.doNothing().`when`(permissionService).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of permissions when successful")
    fun findAll_WhenSuccessful() {
        val response = permissionController.findAll(Pageable.ofSize(15))
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.isEmpty?.let { assertFalse(it) }
    }

    @Test
    @DisplayName("Find permission by id when successful")
    fun findById_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_SAVE
        val response = permissionController.findById(permission.id)
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.let { assert(permission.id == it.id) }
    }

    @Test
    @DisplayName("Create permission when successful")
    fun save_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_SAVE
        val response = permissionController.save(permission.toPermissionRequest())
        assertTrue(response.statusCode == ReturnStatus.CREATED)
        response.body?.let { assert(permission.name == it.name) }
    }

    @Test
    @DisplayName("Update permission when successful")
    fun update_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_SAVE
        val response = permissionController.update(permission.toPermissionRequest(), permission.id)
        assertTrue(response.statusCode == ReturnStatus.UPDATED)
        response.body?.let { assert(permission.name == it.name) }
    }

    @Test
    @DisplayName("Delete permission by id when successful")
    fun deleteById_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_SAVE
        val response = permissionController.deleteById(permission.id)
        assertTrue(response.statusCode == ReturnStatus.DELETED)
    }
}