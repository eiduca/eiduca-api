package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.repository.concrect.IdentityCardRepository
import org.springframework.stereotype.Service

@Service
class IdentityCardService(
    val identityCardRepository: IdentityCardRepository
): ConcreteService<IdentityCard>(identityCardRepository)  {

    fun findByPerson(person: Person): IdentityCard = identityCardRepository.findByPerson(person).orElseThrow { NotFoundException("Not found IdentityCard by id [${person.id}]") }
}