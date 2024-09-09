package app.com.eiduca.module.core.integration.concrete

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.concrete.PermissionCreate
import app.com.eiduca.module.core.model.concrect.Permission
import app.com.eiduca.module.core.service.concrect.PermissionService
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
class PermissionControllerIT {

    @Autowired lateinit var testRestTemplate: TestRestTemplate
    @Autowired lateinit var permissionService: PermissionService
    @Value("\${apiPrefix}")
    lateinit var apiPrefix: String
    val endpoint = "permissions"

    @Test
    @DisplayName("List pageable of permissions when successful")
    fun findAll_WhenSuccessful() {
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint",HttpMethod.GET,null,
            ParameterizedTypeReference.forType<PageableResponse<Permission>>(PageableResponse::class.java)
        )
        assertEquals(exchange.statusCode, ReturnStatus.OK)
    }

    @Test
    @DisplayName("Find permission by id when successful")
    fun findById_WhenSuccessful() {
        val permission = permissionService.saveOrUpdate(PermissionCreate.PERMISSION_SAVE)
        val exchange = testRestTemplate.getForEntity("$apiPrefix/$endpoint/{id}",Permission::class.java, permission.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.OK)
            exchange.body?.let { assertEquals(it.id, permission.id) }
        }
    }

    @Test
    @DisplayName("Create permission when successful")
    fun save_WhenSuccessful() {
        val permission = PermissionCreate.PERMISSION_NOT_EXIST
        val exchange = testRestTemplate.postForEntity("$apiPrefix/$endpoint", permission.toRequest(), Permission::class.java)
        assertPermission(exchange, permission, ReturnStatus.CREATED)
    }

    @Test
    @DisplayName("Update permission when successful")
    fun update_WhenSuccessful() {
        val permission = permissionService.saveOrUpdate(PermissionCreate.PERMISSION_UPDATE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.PUT, HttpEntity(permission.toRequest()), Permission::class.java, permission.id)
        assertPermission(exchange, permission, ReturnStatus.UPDATED)
    }

    @Test
    @DisplayName("Delete permission by id when successful")
    fun deleteById_WhenSuccessful() {
        val permission = permissionService.saveOrUpdate(PermissionCreate.PERMISSION_UPDATE)
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.DELETE, null, Void::class.java, permission.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.DELETED)
        }
    }

    private fun assertPermission(exchange: ResponseEntity<Permission>, permission: Permission, returnStatus: HttpStatus){
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, returnStatus)
            exchange.body?.let {
                assertNotNull(it.id)
                assertEquals(it.name, permission.name)
            }
        }
    }

}