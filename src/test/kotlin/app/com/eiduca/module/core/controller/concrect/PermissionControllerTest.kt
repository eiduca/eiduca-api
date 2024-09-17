package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.module.core.service.concrect.PermissionService
import app.com.eiduca.module.core.create.concrete.PermissionCreate
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.request.PermissionRequest

import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.BeforeEach
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.BDDMockito
import org.mockito.Mock

import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of permission controller")
class PermissionControllerTest: ConcreteControllerTest<Permission, PermissionRequest>() {

    @InjectMocks
    lateinit var permissionController: PermissionController

    @Mock
    lateinit var permissionService: PermissionService

    @BeforeEach
    fun setUp() {
        setUpConcrete(permissionController, permissionService, PermissionCreate.PERMISSION_SAVE)
        BDDMockito.`when`(permissionService.findByName(ArgumentMatchers.anyString())).thenReturn(model)
        BDDMockito.`when`(permissionService.saveOrUpdate(model)).thenReturn(model)
    }

    override fun createModel() = permissionController.save(model.toRequest())

    override fun updateModel() = permissionController.update(model.toRequest(), model.id)
}