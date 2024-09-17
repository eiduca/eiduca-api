package app.com.eiduca.module.academic.common.named

import app.com.eiduca.module.core.common.general.ConcreteServiceTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.data.domain.PageImpl
import java.util.*

@DisplayName("Test codeNamedDescription service")
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
    fun findByCode_ReturnObject_WhenSuccessful() {
        assertDoesNotThrow {
            val codeNamedDescriptionSave = codeNamedDescriptionService.findOrSave(model)
            val codeNamedDescriptionFound = codeNamedDescriptionService.findByCode(model.code)
            assertEquals(codeNamedDescriptionSave, codeNamedDescriptionFound)
        }
    }

    @Test
    fun findByName_ReturnList_WhenSuccessful() {
        codeNamedDescriptionService.save(model)
        AssertUtil.assert(codeNamedDescriptionService.findByName(model.name))
    }

    @Test
    fun findByName_ReturnPage_WhenSuccessful() {
        codeNamedDescriptionService.save(model)
        AssertUtil.assert(codeNamedDescriptionService.findByName(model.name, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByDescription_ReturnList_WhenSuccessful() {
        codeNamedDescriptionService.save(model)
        AssertUtil.assert(codeNamedDescriptionService.findByDescription(model.description))
    }

    @Test
    fun findByDescription_ReturnPage_WhenSuccessful() {
        codeNamedDescriptionService.save(model)
        AssertUtil.assert(codeNamedDescriptionService.findByDescription(model.description, AssertUtil.PAGEABLE))
    }

    override fun runner() {
        model = codeNamedDescriptionService.saveOrUpdate(model)
    }
}