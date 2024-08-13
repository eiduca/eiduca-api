package app.com.eiduca.module.core.common

import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.time.LocalDateTime

abstract class CommonService<T: CommonModel>(
    private val commonRepository: CommonRepository<T>
){

    open  fun findAll(pageable: Pageable): Page<T> = commonRepository.findAll(pageable)

    open fun findById(id: String): T = commonRepository.findById(id).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by id") }

    open fun save(obj: T): T = commonRepository.save(obj)

    open fun update(obj: T): T{
        findById(obj.id)
        return commonRepository.save(obj)
    }

    open fun update(obj: T, id: String): T{
        obj.id = findById(id).id
        return commonRepository.save(obj)
    }

    open fun delete(obj: T){
        commonRepository.delete(obj)
    }

    open fun deleteById(id: String){
        commonRepository.deleteById(id)
    }

}

abstract class ConcreteService<T: ConcreteModel> (
    private val repositoryConcrete: ConcreteRepository<T>
): CommonService<T>(repositoryConcrete){

    override fun findAll(pageable: Pageable): Page<T> = repositoryConcrete.findAll(pageable)

    override fun findById(id: String): T = repositoryConcrete.findById(id).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by id") }

    override fun delete(obj: T) {
        findById(obj.id)
        deleteById(obj.id)
    }

    override fun deleteById(id: String) {
        val entity = findById(id)
        if(entity is IUniqueAttributeModifier) entity.updateUniqueAttributes()
        entity.deletedAt = LocalDateTime.now()
        repositoryConcrete.save(entity)
    }

}