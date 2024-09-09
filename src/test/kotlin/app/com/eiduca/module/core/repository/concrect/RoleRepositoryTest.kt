package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.ConcreteRepositoryTest
import app.com.eiduca.module.core.create.concrete.RoleCreate
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.model.concrect.Role
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.assertEquals

@DataJpaTest
@DisplayName("Test of role repository")
class RoleRepositoryTest(
    @Autowired val roleRepository: RoleRepository
): ConcreteRepositoryTest<Role>(
    roleRepository, RoleCreate.ROLE_SAVE
){
    @Test
    @DisplayName("Find role by name when successful")
    fun findByName_WhenSuccessful(){
        runner()
        persistModel()
        roleRepository.findByName(model.name).ifPresentOrElse(
            { assertEquals(it.name,model.name) },
            { throw NotFoundException("Not found role by name") }
        )
    }

    @Test
    @DisplayName("Find role by description when successful")
    fun findByDescription_WhenSuccessful(){
        runner()
        persistModel()
        roleRepository.findByDescription(model.description).ifPresentOrElse(
            { assertEquals(it.description, model.description) },
            { throw NotFoundException("Not found role by description") }
        )
    }

    override fun runner() = roleRepository.deleteAll()

    override fun persistModel() {
        model = roleRepository.findByName(model.name).orElse(roleRepository.save(model))
    }

}