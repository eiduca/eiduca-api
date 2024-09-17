package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.named.NamedDescriptionServiceTest
import app.com.eiduca.module.core.create.concrete.PermissionCreate
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.repository.concrect.PermissionRepository
import app.com.eiduca.module.core.util.AssertUtil

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of permission service")
class PermissionServiceTest: NamedDescriptionServiceTest<Permission>() {
    @InjectMocks
    lateinit var permissionService: PermissionService
    @Mock
    lateinit var permissionRepository: PermissionRepository

    @BeforeEach
    fun setUp() {
        setUpNamedDescription(permissionService, permissionRepository, PermissionCreate.PERMISSION_SAVE)
        val list = mutableListOf(model)
        BDDMockito.`when`(permissionRepository.findByEntity(model.entity)).thenReturn(list)
        BDDMockito.`when`(permissionRepository.findByEntity(model.entity, AssertUtil.PAGEABLE)).thenReturn(PageImpl(list))
    }

    @Test
    fun findByEntity_ReturnList_WhenSuccessful() {
        AssertUtil.assert(permissionService.findByEntity(model.entity))
    }

    @Test
    fun findByEntity_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(permissionService.findByEntity(model.entity, AssertUtil.PAGEABLE))
    }
}