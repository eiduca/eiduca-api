package app.com.eiduca.module.core.common.general

import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.transaction.annotation.Transactional

@Transactional
abstract class CommonRepositoryTest <T: CommonModel>(
    var repository: CommonRepository<T>,
    var model: T
){
    @Test
    @DisplayName("Find model by id when successful")
    fun findById_WhenSuccessful() {
        runner()
        persistModel()
        repository.findById(model.id).ifPresentOrElse(
            { assert(it == model) },
            { throw NotFoundException("Not found ${model.javaClass.simpleName} by id") }
        )
    }

    @Test
    @DisplayName("List pageable of model when successful")
    fun findByAll_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findAll(AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Create model  when successful")
    fun save_WhenSuccessful(){
        runner()
        persistModel()
        assertNotNull(model.id)
        assert(model == model)
    }

    @Test
    @DisplayName("Delete model by id when successful")
    fun deleteById_WhenSuccessful() {
        runner()
        persistModel()
        repository.deleteById(model.id)
        assertTrue(repository.findById(model.id).isEmpty)
    }

    fun persistModel() {
        model = repository.save(model)
    }

    fun runner(){}
}

abstract class ConcreteRepositoryTest <T: ConcreteModel>(
    repository: ConcreteRepository<T>,
    model: T,
): CommonRepositoryTest<T>(repository, model)