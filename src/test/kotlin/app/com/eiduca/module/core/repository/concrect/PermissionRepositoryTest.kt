package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.create.concrete.PermissionCreate
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.Pageable

@DataJpaTest
@DisplayName("Test of permission repository")
class PermissionRepositoryTest{

    @Autowired
    lateinit var permissionRepository: PermissionRepository

    @Test
    @DisplayName("List pageable of permissions when successful")
    fun findAll_WhenSuccessful() {
        permissionRepository.save(PermissionCreate.PERMISSION_SAVE)
        val response = permissionRepository.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find permission by id when successful")
    fun findById_WhenSuccessful() {
        assertDoesNotThrow {
            val permission = permissionRepository.save(PermissionCreate.PERMISSION_NOT_EXIST)
            permissionRepository.findById(permission.id).ifPresentOrElse({
                assertEquals(it.id, permission.id)
            },{throw NotFoundException("Not found role by id")})
        }
    }

    @Test
    @DisplayName("Find permission by name when successful")
    fun findByName_WhenSuccessful(){
        val permission = PermissionCreate.PERMISSION_SAVE
        permissionRepository.save(permission)
        permissionRepository.findByName(permission.name).ifPresentOrElse({
            assert(it.name == permission.name)
        }, {throw NotFoundException("Not found permission by name") })
    }

    @Test
    @DisplayName("Create permission when successful")
    fun save_WhenSuccessful(){
        val permission = PermissionCreate.PERMISSION_SAVE
        val permissionSave = permissionRepository.save(permission)
        assertNotNull(permissionSave.id)
        assert(permissionSave == permission)
    }

    @Test
    @DisplayName("Delete permission by id when successful")
    fun deleteById_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_UPDATE
       assertDoesNotThrow {
            permissionRepository.deleteById(permission.id)
           assertTrue(permissionRepository.findById(permission.id).isEmpty)
        }
    }

}