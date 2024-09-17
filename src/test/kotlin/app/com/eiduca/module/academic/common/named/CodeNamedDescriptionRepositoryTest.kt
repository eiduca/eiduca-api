package app.com.eiduca.module.academic.common.named

import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Test codeNamedDescription repository")
abstract class CodeNamedDescriptionRepositoryTest<T: CodeNamedDescriptionModel>(
    private val codeNamedDescriptionRepository: CodeNamedDescriptionRepository<T>,
    model: T,
): ConcreteRepositoryTest<T>(codeNamedDescriptionRepository, model) {

    @Test
    fun findByCode_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        codeNamedDescriptionRepository.findByCode(model.code).ifPresentOrElse(
            { assert(it == model) },
            { throw NotFoundException("Not found model codeNamedDescription by code") }
        )
    }

    @Test
    fun findByName_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(codeNamedDescriptionRepository.findByName(model.name))
    }

    @Test
    fun findByName_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(codeNamedDescriptionRepository.findByName(model.name, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByDescription_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(codeNamedDescriptionRepository.findByDescription(model.description))
    }

    @Test
    fun findByDescription_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(codeNamedDescriptionRepository.findByDescription(model.description, AssertUtil.PAGEABLE))
    }

    override fun runner() = codeNamedDescriptionRepository.deleteAll()

    override fun persistModel() {
        model = codeNamedDescriptionRepository.findByCode(model.code).orElse(codeNamedDescriptionRepository.save(model))
    }
}