package app.com.eiduca.module.academic.common.named

import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.transaction.annotation.Transactional

@Transactional
abstract class CodeNamedDescriptionRepositoryTest<T: CodeNamedDescriptionModel>(
    private val codeNamedDescriptionRepository: CodeNamedDescriptionRepository<T>,
    model: T,
): ConcreteRepositoryTest<T>(codeNamedDescriptionRepository, model) {

    @Test
    @DisplayName("Find model[codeNamedDescription] by code when successful")
    fun findByCode_WhenSuccessful() {
        runner()
        persistModel()
        codeNamedDescriptionRepository.findByCode(model.code).ifPresentOrElse(
            { assert(it == model) },
            { throw NotFoundException("Not found model codeNamedDescription by code") }
        )
    }

    @Test
    @DisplayName("Find model[codeNamedDescription] by name when successful, return list")
    fun findByName_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(codeNamedDescriptionRepository.findByName(model.name))
    }

    @Test
    @DisplayName("Find model[codeNamedDescription] by name when successful, return list pageable")
    fun findByName_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(codeNamedDescriptionRepository.findByName(model.name, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find model[codeNamedDescription] by name when successful, return list")
    fun findByDescription_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(codeNamedDescriptionRepository.findByDescription(model.description))
    }

    @Test
    @DisplayName("Find model[codeNamedDescription] by name when successful, return list pageable")
    fun findByDescription_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(codeNamedDescriptionRepository.findByDescription(model.description, AssertUtil.PAGEABLE))
    }

    override fun runner() = codeNamedDescriptionRepository.deleteAll()
}