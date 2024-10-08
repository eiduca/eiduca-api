package app.com.eiduca.module.core.common.general

import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

@DisplayName("Test common service")
abstract class CommonServiceTest <T: CommonModel> {

    lateinit var model: T
    private lateinit var commonService: CommonService<T>
    private lateinit var commonRepository: CommonRepository<T>

    fun setUpCommon(commonService: CommonService<T>, commonRepository: CommonRepository<T>, model: T) {
        val entities = PageImpl(mutableListOf(model))

        this.model = model
        this.commonService = commonService
        this.commonRepository = commonRepository

        BDDMockito.`when`(commonRepository.findAll(AssertUtil.PAGEABLE)).thenReturn(entities)
        BDDMockito.`when`(commonRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(model))
        BDDMockito.`when`(commonRepository.save(model)).thenReturn(model)
        BDDMockito.doNothing().`when`(commonRepository).delete(model)
        BDDMockito.doNothing().`when`(commonRepository).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    fun findAll_ReturnPage_WhenSuccessful() {
        runner()
        AssertUtil.assert(commonService.findAll(AssertUtil.PAGEABLE))
    }

    @Test
    fun findById_ReturnObject_WhenSuccessful() {
        runner()
        assertDoesNotThrow {
            commonService.findById(model.id)
        }
    }

    @Test
    fun save_ReturnObject_WhenSuccessful() {
        val entity = persistModel()
        assertNotNull(entity.id)
        assert(entity == model)
    }

    @Test
    fun update_ReturnObject_WhenSuccessful() {
        assertDoesNotThrow {
            val entity = persistModel()
            commonService.update(model, entity.id)
        }
    }

    @Test
    open fun deleteById_ReturnVoid_WhenSuccessful(){
        assertDoesNotThrow {
        val response = commonService.deleteById(model.id)
        }
    }

    @Test
    fun findOrSave_ReturnObject_WhenSuccessful() {
        assertDoesNotThrow {
            val response = commonService.findOrSave(model)
            kotlin.test.assertNotNull(response.id)
            assertEquals(response, model)
        }
    }

    @Test
    fun saveOrUpdate_ReturnObject_WhenSuccessful() {
        assertDoesNotThrow {
            val response = commonService.saveOrUpdate(model)
            kotlin.test.assertNotNull(response.id)
            assertEquals(response, model)
        }
    }

    open fun runner(){}

    open fun persistModel() = commonService.save(model)
}

@DisplayName("Test concrete service")
abstract class ConcreteServiceTest <T: ConcreteModel>: CommonServiceTest<T>(){
    private lateinit var concreteService: ConcreteService<T>
    private lateinit var concreteRepository: ConcreteRepository<T>

    fun setUpConcrete(concreteService: ConcreteService<T>, concreteRepository: ConcreteRepository<T>, model: T){
        setUpCommon(concreteService, concreteRepository, model)

        this.concreteRepository = concreteRepository
        this.concreteService = concreteService
        this.model = model

        BDDMockito.doNothing().`when`(concreteRepository).delete(model)
        BDDMockito.doNothing().`when`(concreteRepository).deleteById(ArgumentMatchers.anyString())
    }

}