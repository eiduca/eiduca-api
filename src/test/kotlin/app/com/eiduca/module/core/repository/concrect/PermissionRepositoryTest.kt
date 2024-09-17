package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.named.NamedDescriptionRepositoryTest
import app.com.eiduca.module.core.create.concrete.PermissionCreate
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of permission repository")
class PermissionRepositoryTest(
    @Autowired val permissionRepository: PermissionRepository
): NamedDescriptionRepositoryTest<Permission>(
    permissionRepository, PermissionCreate.PERMISSION_SAVE
){
    @Test
    fun findByEntity_ReturnList_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(permissionRepository.findByEntity(model.entity))
    }

    @Test
    fun findByEntity_ReturnPage_WhenSuccessful() {
        persistModel()
        AssertUtil.assert(permissionRepository.findByEntity(model.entity, AssertUtil.PAGEABLE))
    }
}