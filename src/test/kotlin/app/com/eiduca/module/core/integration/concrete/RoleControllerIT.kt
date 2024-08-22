package app.com.eiduca.module.core.integration.concrete

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.concrete.RoleCreate
import app.com.eiduca.module.core.model.concrect.Role
import app.com.eiduca.module.core.service.concrect.RoleService
import app.com.eiduca.module.core.wrapper.PageableResponse
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoleControllerIT {

    @Autowired lateinit var testRestTemplate: TestRestTemplate
    @Autowired lateinit var roleService: RoleService
    @Value("\${apiPrefix}")
    lateinit var apiPrefix: String
    val endpoint = "roles"

    @Test
    @DisplayName("List pageable of roles when successful")
    fun findAll_WhenSuccessful() {
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint",HttpMethod.GET,null,
            ParameterizedTypeReference.forType<PageableResponse<Role>>(PageableResponse::class.java)
        )
        assertEquals(exchange.statusCode, ReturnStatus.OK)
    }

    @Test
    @DisplayName("Find role by id when successful")
    fun findById_WhenSuccessful() {
        val role = roleService.saveOrUpdate(RoleCreate.ROLE_SAVE)
        val exchange = testRestTemplate.getForEntity("$apiPrefix/$endpoint/{id}",Role::class.java, role.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.OK)
            exchange.body?.let { assertEquals(it.id, role.id) }
        }
    }

    @Test
    @DisplayName("Create role when successful")
    fun save_WhenSuccessful() {
        val role = RoleCreate.ROLE_NOT_EXIST
        val exchange = testRestTemplate.postForEntity("$apiPrefix/$endpoint", role.toRoleRequest(), Role::class.java)
        assertRole(exchange, role, ReturnStatus.CREATED)
    }

    @Test
    @DisplayName("Update role when successful")
    fun update_WhenSuccessful() {
        val role = roleService.saveOrUpdate(RoleCreate.ROLE_SAVE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.PUT, HttpEntity(role.toRoleRequest()), Role::class.java, role.id)
        assertRole(exchange, role, ReturnStatus.UPDATED)
    }

    @Test
    @DisplayName("Delete role by id when successful")
    fun deleteById_WhenSuccessful() {
        val role = roleService.saveOrUpdate(RoleCreate.ROLE_UPDATE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.DELETE, null, Void::class.java, role.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.DELETED)
        }
    }

    private fun assertRole(exchange: ResponseEntity<Role>, person: Role, returnStatus: HttpStatus){
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, returnStatus)
            exchange.body?.let {
                assertNotNull(it.id)
                assertEquals(it.name, person.name)
            }
        }
    }

}