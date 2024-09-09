package app.com.eiduca.module.core.common

import app.com.eiduca.module.core.common.general.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

abstract class CommonServiceTest <T: CommonModel> {

    lateinit var model: T
    private lateinit var commonService: CommonService<T>
    private lateinit var commonRepository: CommonRepository<T>

    fun setUpCommon(commonService: CommonService<T>, commonRepository: CommonRepository<T>, model: T) {
        val entities = PageImpl(mutableListOf(model))

        this.model = model
        this.commonService = commonService
        this.commonRepository = commonRepository

        BDDMockito.`when`(commonRepository.findAll(Pageable.ofSize(15))).thenReturn(entities)
        BDDMockito.`when`(commonRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(model))
        BDDMockito.`when`(commonRepository.save(model)).thenReturn(model)
        BDDMockito.doNothing().`when`(commonRepository).delete(model)
        BDDMockito.doNothing().`when`(commonRepository).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of common when successful")
    fun findAll_WhenSuccessful() {
        runner()
        assertFalse(commonService.findAll(Pageable.ofSize(15)).isEmpty)
    }

    @Test
    @DisplayName("Find common by id when successful")
    fun findById_WhenSuccessful() {
        runner()
        assertDoesNotThrow {
            commonService.findById(model.id)
        }
    }

    @Test
    @DisplayName("Create common when successful")
    fun save_WhenSuccessful() {
        val entity = persistModel()
        assertNotNull(entity.id)
        assert(entity == model)
    }

    @Test
    @DisplayName("Update common when successful")
    fun update_WhenSuccessful() {
        assertDoesNotThrow {
            val entity = persistModel()
            commonService.update(model, entity.id)
        }
    }

    @Test
    @DisplayName("Delete common by id when successful")
    open fun deleteById_WhenSuccessful(){
        assertDoesNotThrow {
        val response = commonService.deleteById(model.id)
        }
    }

    open fun runner(){}

    open fun persistModel() = commonService.save(model)
}

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