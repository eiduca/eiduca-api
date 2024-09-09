package app.com.eiduca.module.core.common

import app.com.eiduca.module.core.common.general.CommonModel
import app.com.eiduca.module.core.common.general.CommonRepository
import app.com.eiduca.module.core.common.general.ConcreteModel
import app.com.eiduca.module.core.common.general.ConcreteRepository
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable

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
        assertFalse(repository.findAll(Pageable.ofSize(15)).isEmpty)
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

    open fun persistModel() {
        model = repository.save(model)
    }

    open fun runner(){}
}

abstract class ConcreteRepositoryTest <T: ConcreteModel>(
    @Autowired repository: ConcreteRepository<T>,
    model: T,
): CommonRepositoryTest<T>(repository, model)