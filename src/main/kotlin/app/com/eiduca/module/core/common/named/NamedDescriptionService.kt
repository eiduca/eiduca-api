package app.com.eiduca.module.core.common.named

import app.com.eiduca.module.core.common.general.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException

abstract class NamedDescriptionService<T: NamedDescriptionModel> (
    private val namedDescriptionRepository: NamedDescriptionRepository<T>
): ConcreteService<T>(namedDescriptionRepository){

    fun findByName(name: String): T = namedDescriptionRepository.findByName(name).orElseThrow { NotFoundException("Not found namedDescription by name [$name]") }

    fun findByDescription(description: String): T = namedDescriptionRepository.findByDescription(description).orElseThrow { NotFoundException("Not found namedDescription by description [$description]") }

    override fun deleteIfExist(obj: T) = hidden(findByName(obj.name))

    override fun saveOrUpdate(obj: T): T {
        namedDescriptionRepository.findByName(obj.name).ifPresent { obj.id = it.id }
        return  namedDescriptionRepository.save(obj)
    }
}