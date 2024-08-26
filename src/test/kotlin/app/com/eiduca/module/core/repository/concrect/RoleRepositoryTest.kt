package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.create.concrete.RoleCreate
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.Pageable

@DataJpaTest
@DisplayName("Test of role repository")
class RoleRepositoryTest{

    @Autowired
    lateinit var roleRepository: RoleRepository

    @Test
    @DisplayName("List pageable of roles when successful")
    fun findAll_WhenSuccessful() {
        roleRepository.save(RoleCreate.ROLE_SAVE)
        val response = roleRepository.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find role by id when successful")
    fun findById_WhenSuccessful() {
        assertDoesNotThrow {
            val role = roleRepository.save(RoleCreate.ROLE_NOT_EXIST)
            roleRepository.findById(role.id).ifPresentOrElse({
                assertEquals(it.id, role.id)
            },{throw NotFoundException("Not found role by id")})
        }
    }

    @Test
    @DisplayName("Find role by name when successful")
    fun findByName_WhenSuccessful(){
        val role = RoleCreate.ROLE_SAVE
        roleRepository.save(role)
        roleRepository.findByName(role.name).ifPresentOrElse({
            assert(it.name == role.name)
        }, {throw NotFoundException("Not found role by name") })
    }

    @Test
    @DisplayName("Create role when successful")
    fun save_WhenSuccessful(){
        val role = RoleCreate.ROLE_SAVE
        val roleSave = roleRepository.save(role)
        assertNotNull(roleSave.id)
        assert(roleSave == role)
    }

    @Test
    @DisplayName("Delete role by id when successful")
    fun deleteById_WhenSuccessful() {
        val role = RoleCreate.ROLE_UPDATE
       assertDoesNotThrow {
            roleRepository.deleteById(role.id)
           assertTrue(roleRepository.findById(role.id).isEmpty)
        }
    }

}