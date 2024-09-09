package app.com.eiduca.module.academic.common.named

import app.com.eiduca.module.core.common.ConcreteServiceTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.data.domain.PageImpl
import java.util.*
import kotlin.test.assertNotNull

abstract class CodeNamedDescriptionServiceTest <T: CodeNamedDescriptionModel>: ConcreteServiceTest<T>() {

    private lateinit var codeNamedDescriptionService: CodeNamedDescriptionService<T>
    private lateinit var codeNamedDescriptionRepository: CodeNamedDescriptionRepository<T>

    fun setUpCodeNamedDescription(codeNamedDescriptionService: CodeNamedDescriptionService<T>, codeNamedDescriptionRepository: CodeNamedDescriptionRepository<T>, model: T) {
        setUpConcrete(codeNamedDescriptionService, codeNamedDescriptionRepository, model)

        this.codeNamedDescriptionService = codeNamedDescriptionService
        this.codeNamedDescriptionRepository = codeNamedDescriptionRepository
        this.model = model

        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(codeNamedDescriptionRepository.findByCode(model.code)).thenReturn(Optional.of(model))
        BDDMockito.`when`(codeNamedDescriptionRepository.findByName(model.name)).thenReturn(list)
        BDDMockito.`when`(codeNamedDescriptionRepository.findByName(model.name, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(codeNamedDescriptionRepository.findByDescription(model.description)).thenReturn(list)
        BDDMockito.`when`(codeNamedDescriptionRepository.findByDescription(model.description, AssertUtil.PAGEABLE)).thenReturn(page)
    }

    @Test
    @DisplayName("Find model[codeNamedDescription] by code when successful")
    fun findByCode_WhenSuccessful() {
        assertDoesNotThrow {
            val codeNamedDescriptionSave = codeNamedDescriptionService.save(model)
            val codeNamedDescriptionFound = codeNamedDescriptionService.findByCode(model.code)
            assertEquals(codeNamedDescriptionSave, codeNamedDescriptionFound)
        }
    }

    @Test
    @DisplayName("Find model[codeNamedDescription] by name when successful, return list")
    fun findByName_ReturnList_WhenSuccessful() {
        codeNamedDescriptionService.save(model)
        AssertUtil.assert(codeNamedDescriptionService.findByName(model.name))
    }

    @Test
    @DisplayName("Find model[codeNamedDescription] by name when successful, return list pageable")
    fun findByName_ReturnPage_WhenSuccessful() {
        codeNamedDescriptionService.save(model)
        AssertUtil.assert(codeNamedDescriptionService.findByName(model.name, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find model[codeNamedDescription] by name when successful, return list")
    fun findByDescription_ReturnList_WhenSuccessful() {
        codeNamedDescriptionService.save(model)
        AssertUtil.assert(codeNamedDescriptionService.findByDescription(model.description))
    }

    @Test
    @DisplayName("Find model[codeNamedDescription] by name when successful, return list pageable")
    fun findByDescription_ReturnPage_WhenSuccessful() {
        codeNamedDescriptionService.save(model)
        AssertUtil.assert(codeNamedDescriptionService.findByDescription(model.description, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Create or update model[codeNamedDescription] when successful")
    fun saveOrUpdate() {
        org.junit.jupiter.api.assertDoesNotThrow {
            val response = codeNamedDescriptionService.saveOrUpdate(model)
            assertNotNull(response.id)
            kotlin.test.assertEquals(response.code, model.code)
        }
    }
}