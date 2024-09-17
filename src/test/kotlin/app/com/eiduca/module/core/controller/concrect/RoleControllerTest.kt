package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.module.core.service.concrect.RoleService
import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import app.com.eiduca.module.core.create.concrete.RoleCreate
import app.com.eiduca.module.core.model.concrect.Role
import app.com.eiduca.module.core.request.RoleRequest

import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.BeforeEach
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock

import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of role controller")
class RoleControllerTest: ConcreteControllerTest<Role, RoleRequest>() {
    @InjectMocks
    lateinit var roleController: RoleController
    @Mock
    lateinit var roleService: RoleService

    @BeforeEach
    fun setUp(){
        setUpConcrete(roleController, roleService, RoleCreate.ROLE_SAVE)
        BDDMockito.`when`(roleService.findByName(ArgumentMatchers.anyString())).thenReturn(model)
        BDDMockito.`when`(roleService.saveOrUpdate(model)).thenReturn(model)
    }

    override fun createModel() = roleController.save(model.toRequest())

    override fun updateModel() = roleController.update(model.toRequest(), model.id)
}