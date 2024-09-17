package app.com.eiduca.module.core.common.general

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.springframework.data.domain.PageImpl
import org.springframework.http.ResponseEntity

@DisplayName("Test common controller")
abstract class CommonControllerTest <T: CommonModel, R: IConvertModel<T> >{

    lateinit var model: T
    private lateinit var commonController: CommonController<T, R>
    private lateinit var commonService: CommonService<T>

    fun setUpCommon(commonController: CommonController<T, R>, commonService: CommonService<T>, model: T) {
        val entities = PageImpl(mutableListOf(model))

        this.commonController = commonController
        this.commonService = commonService
        this.model = model

        BDDMockito.`when`(commonService.findAll(AssertUtil.PAGEABLE)).thenReturn(entities)
        BDDMockito.`when`(commonService.findById(ArgumentMatchers.anyString())).thenReturn(model)
        BDDMockito.`when`(commonService.save(model)).thenReturn(model)
        BDDMockito.doNothing().`when`(commonService).delete(model)
        BDDMockito.doNothing().`when`(commonService).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    fun findAll_ReturnPage_WhenSuccessful() {
        runner()
        val response = commonController.findAll(AssertUtil.PAGEABLE)
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.isEmpty?.let { assertFalse(it) }
    }

    @Test
    fun findById_ReturnObject_WhenSuccessful() {
        runner()
        val response = commonController.findById(model.id)
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.let { assert(model.id == it.id) }
    }

    @Test
    fun save_ReturnObject_WhenSuccessful() {
        runner()
        val response = createModel()
        assertTrue(response.statusCode == ReturnStatus.CREATED)
        response.body?.let { assert(model == it) }
    }

    @Test
    fun update_ReturnObject_WhenSuccessful() {
        runner()
        val response = updateModel()
        assertTrue(response.statusCode == ReturnStatus.UPDATED)
        response.body?.let { assert(model == it) }
    }

    @Test
    fun deleteById_ReturnVoid_WhenSuccessful() {
        runner()
        val response = commonController.deleteById(model.id)
        assertTrue(response.statusCode == ReturnStatus.DELETED)
    }

    fun runner(){}

    abstract fun createModel(): ResponseEntity<T>

    abstract fun updateModel(): ResponseEntity<T>
}

abstract class ConcreteControllerTest <T: ConcreteModel,  R: IConvertModel<T> >: CommonControllerTest<T, R>(){

    private lateinit var concreteController: CommonController<T, R>
    private lateinit var concreteService: CommonService<T>

    fun setUpConcrete(concreteController: ConcreteController<T, R>, concreteService: ConcreteService<T>, model: T) {
        setUpCommon(concreteController, concreteService, model)
        this.concreteController = concreteController
        this.concreteService = concreteService
    }
}