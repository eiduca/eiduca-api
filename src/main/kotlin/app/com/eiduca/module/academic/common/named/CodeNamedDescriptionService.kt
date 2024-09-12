package app.com.eiduca.module.academic.common.named

import app.com.eiduca.module.core.common.general.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

abstract class CodeNamedDescriptionService<T: CodeNamedDescriptionModel>(
    private val codeNamedDescriptionRepository: CodeNamedDescriptionRepository<T>,
): ConcreteService<T>(codeNamedDescriptionRepository) {

    fun findByCode(code: String): T = codeNamedDescriptionRepository.findByCode(code).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by name") }

    fun findByName(name: String): List<T> = codeNamedDescriptionRepository.findByName(name)

    fun findByName(name: String, pageable: Pageable): Page<T> = codeNamedDescriptionRepository.findByName(name, pageable)

    fun findByDescription(description: String?): List<T> = codeNamedDescriptionRepository.findByDescription(description)

    fun findByDescription(description: String?, pageable: Pageable): Page<T> = codeNamedDescriptionRepository.findByDescription(description, pageable)

    override fun deleteIfExist(obj: T) = codeNamedDescriptionRepository.findByCode(obj.code).ifPresent { hidden(it) }

    override fun saveOrUpdate(obj: T): T {
        codeNamedDescriptionRepository.findByCode(obj.code).ifPresent { obj.id = it.id }
        return codeNamedDescriptionRepository.save(obj)
    }
}