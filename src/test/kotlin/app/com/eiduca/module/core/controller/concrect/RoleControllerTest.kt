package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.concrete.RoleCreate
import app.com.eiduca.module.core.seed.RoleSeed
import app.com.eiduca.module.core.service.concrect.RoleService
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
@DisplayName("Test of role controller")
class RoleControllerTest {

    @InjectMocks
    lateinit var roleController: RoleController

    @Mock
    lateinit var roleService: RoleService

    @BeforeEach
    fun setUp() {
        val role = RoleCreate.ROLE_SAVE
        val roles = PageImpl(RoleSeed.entries.map { it.role })
        BDDMockito.`when`(roleService.findAll(Pageable.ofSize(15))).thenReturn(roles)
        BDDMockito.`when`(roleService.findById(ArgumentMatchers.anyString())).thenReturn(role)
        BDDMockito.`when`(roleService.save(role)).thenReturn(role)
        BDDMockito.doNothing().`when`(roleService).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of roles when successful")
    fun findAll_WhenSuccessful() {
        val response = roleController.findAll(Pageable.ofSize(15))
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.isEmpty?.let { assertFalse(it) }
    }

    @Test
    @DisplayName("Find role by id when successful")
    fun findById_WhenSuccessful() {
        val role = RoleCreate.ROLE_SAVE
        val response = roleController.findById(role.id)
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.let { assert(role.id == it.id) }
    }

    @Test
    @DisplayName("Create role when successful")
    fun save_WhenSuccessful() {
        val role = RoleCreate.ROLE_SAVE
        val response = roleController.save(role.toRoleRequest())
        assertTrue(response.statusCode == ReturnStatus.CREATED)
        response.body?.let { assert(role.name == it.name) }
    }

    @Test
    @DisplayName("Update role when successful")
    fun update_WhenSuccessful() {
        val role = RoleCreate.ROLE_UPDATE
        val response = roleController.update(role.toRoleRequest(), role.id)
        assertTrue(response.statusCode == ReturnStatus.UPDATED)
        response.body?.let { assert(role.name == it.name) }
    }

    @Test
    @DisplayName("Delete role by id when successful")
    fun deleteById_WhenSuccessful() {
        val role = RoleCreate.ROLE_UPDATE
        val response = roleController.deleteById(role.id)
        assertTrue(response.statusCode == ReturnStatus.DELETED)
    }
}