package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.ConcreteRepositoryTest
import app.com.eiduca.module.core.create.concrete.PermissionCreate
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.Permission
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of permission repository")
class PermissionRepositoryTest(
    @Autowired val permissionRepository: PermissionRepository
): ConcreteRepositoryTest<Permission>(
    permissionRepository, PermissionCreate.PERMISSION_NOT_EXIST
){

    @Test
    @DisplayName("Find permission by name when successful")
    fun findByName_WhenSuccessful(){
        runner()
        persistModel()
        permissionRepository.findByName(model.name).ifPresentOrElse(
            { assert(it.name == model.name) },
            { throw NotFoundException("Not found permission by name") }
        )
    }

    @Test
    @DisplayName("Find permission by description when successful")
    fun findByDescription_WhenSuccessful(){
        runner()
        persistModel()
        permissionRepository.findByDescription(model.description).ifPresentOrElse(
            { assert(it.description == model.description) },
            { throw NotFoundException("Not found permission by description") }
        )
    }

    override fun runner() = permissionRepository.deleteAll()

    override fun persistModel(){
        model = permissionRepository.findByName(model.name).orElse(permissionRepository.save(model))
    }
}