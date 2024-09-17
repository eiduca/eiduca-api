package app.com.eiduca.module.core.common.general

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

    open fun deleteIfExist(obj: T) = delete(obj)

    fun deleteAll() = commonRepository.deleteAll()

    abstract fun findOrSave(obj: T): T

    abstract fun saveOrUpdate(obj: T): T
}

abstract class ConcreteService<T: ConcreteModel> (
    private val concreteRepository: ConcreteRepository<T>
): CommonService<T>(concreteRepository){

    override fun findAll(pageable: Pageable): Page<T> = concreteRepository.findAll(pageable)

    override fun findById(id: String): T = concreteRepository.findById(id).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by id ($id)") }

    override fun delete(obj: T) = deleteById(obj.id)

    override fun deleteById(id: String) = concreteRepository.findById(id).ifPresent { hidden(it) }

    override fun deleteIfExist(obj: T) = concreteRepository.findById(obj.id).ifPresent { hidden(it) }

    fun destroyById(id: String) =  concreteRepository.delete(findById(id))

    open fun destroy(obj: T) = concreteRepository.delete(obj)

    open fun destroyAll() = concreteRepository.deleteAll()

    open fun destroyIfExist(obj: T) = concreteRepository.delete(obj)

    protected fun hidden(entity: T){
        if(entity is IUniqueAttributeModifier) entity.updateUniqueAttributes()
        entity.deletedAt = LocalDateTime.now()
        concreteRepository.save(entity)
    }
}

abstract class PivotService<T: PivotModel> (
    pivotRepository: PivotRepository<T>
): CommonService<T>(pivotRepository){

    override fun saveOrUpdate(obj: T): T = findOrSave(obj)

    override fun save(obj: T): T = saveOrUpdate(obj)
}