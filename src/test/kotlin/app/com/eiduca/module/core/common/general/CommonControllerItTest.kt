package app.com.eiduca.module.core.common.general

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.wrapper.PageableResponse
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

abstract class CommonControllerItTest<T: CommonModel>(
    val commonService: CommonService<T>,
    var model: T,
    val endpoint: String,
) {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Value("\${apiPrefix}")
    lateinit var apiPrefix: String

    @Test
    @DisplayName("List pageable of common when successful")
    fun findAll_WhenSuccessful() {
        runner()
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint", HttpMethod.GET,null,
            ParameterizedTypeReference.forType<PageableResponse<T>>(PageableResponse::class.java)
        )
        assertEquals(exchange.statusCode, ReturnStatus.OK)
    }

    @Test
    @DisplayName("Find common by id when successful")
    fun findById_WhenSuccessful() {
        runner()
        model = createModel()
        val exchange = testRestTemplate.getForEntity("$apiPrefix/$endpoint/{id}",model::class.java, model.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.OK)
            exchange.body?.let { assertEquals(it.id, model.id) }
        }
    }

    @Test
    @DisplayName("Create common when successful")
    fun save_WhenSuccessful() {
        runner()
        runnerSave()
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint", HttpMethod.POST, HttpEntity(requestModel()), model::class.java)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.CREATED)
            exchange.body?.let { assertNotNull(it) }
        }
    }

    @Test
    @DisplayName("Update common when successful")
    fun update_WhenSuccessful() {
        runner()
        model = createModel()
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.PUT, HttpEntity(requestModel()), model::class.java, model.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.UPDATED)
            exchange.body?.let { assertNotNull(it) }
        }
    }

    @Test
    @DisplayName("Delete common by id when successful")
    fun deleteById_WhenSuccessful() {
        runner()
        model = createModel()
        val exchange = testRestTemplate.exchange("$apiPrefix/$endpoint/{id}",HttpMethod.DELETE, null, Void::class.java, model.id)
        assertDoesNotThrow {
            assertEquals(exchange.statusCode, ReturnStatus.DELETED)
        }
    }

    open fun createModel(): T = commonService.save(model)

    open fun runnerSave() = commonService.deleteIfExist(model)

    open fun runner(){}

    abstract fun requestModel(): IConvertModel<T>
}

abstract class ConcreteControllerItTest<T: ConcreteModel>(
    private val concreteService: ConcreteService<T>,
    model: T,
    endpoint: String,
): CommonControllerItTest<T>(
    concreteService, model, endpoint
){
    override fun createModel(): T = concreteService.saveOrUpdate(model)

    override fun runnerSave() = concreteService.deleteIfExist(model)
}