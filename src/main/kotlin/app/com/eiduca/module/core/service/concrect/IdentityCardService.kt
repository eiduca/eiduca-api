package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.general.ConcreteService
import app.com.eiduca.module.core.enums.MaritalStatus
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.repository.concrect.IdentityCardRepository
import app.com.eiduca.module.core.util.GeneratorNanoID
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class IdentityCardService(
    val identityCardRepository: IdentityCardRepository
): ConcreteService<IdentityCard>(identityCardRepository)  {

    fun findByCode(code: String): IdentityCard = identityCardRepository.findByCode(code).orElseThrow { NotFoundException("Not found IdentityCard by code ($code)") }

    fun findByPerson(person: Person): List<IdentityCard> = identityCardRepository.findByPerson(person)

    fun findByPerson(person: Person, pageable: Pageable): Page<IdentityCard> = identityCardRepository.findByPerson(person, pageable)

    fun findByResidential(residential: String): List<IdentityCard> = identityCardRepository.findByResidential(residential)

    fun findByResidential(residential: String, pageable: Pageable): Page<IdentityCard> = identityCardRepository.findByResidential(residential, pageable)

    fun findByNaturalFrom(naturalFrom: String): List<IdentityCard> = identityCardRepository.findByNaturalFrom(naturalFrom)

    fun findByNaturalFrom(naturalFrom: String, pageable: Pageable): Page<IdentityCard> = identityCardRepository.findByNaturalFrom(naturalFrom, pageable)

    fun findByEmittedFrom(emittedFrom: String): List<IdentityCard> = identityCardRepository.findByEmittedFrom(emittedFrom)

    fun findByEmittedFrom(emittedFrom: String, pageable: Pageable): Page<IdentityCard> = identityCardRepository.findByEmittedFrom(emittedFrom, pageable)

    fun findByEmittedAt(emittedAt: LocalDate): List<IdentityCard> = identityCardRepository.findByEmittedAt(emittedAt)

    fun findByEmittedAt(emittedAt: LocalDate, pageable: Pageable): Page<IdentityCard> = identityCardRepository.findByEmittedAt(emittedAt, pageable)

    fun findByValidAt(validAt: LocalDate): List<IdentityCard> = identityCardRepository.findByValidAt(validAt)

    fun findByValidAt(validAt: LocalDate, pageable: Pageable): Page<IdentityCard> = identityCardRepository.findByValidAt(validAt, pageable)

    fun findByMaritalStatus(maritalStatus: MaritalStatus): List<IdentityCard> = identityCardRepository.findByMaritalStatus(maritalStatus)

    fun findByMaritalStatus(maritalStatus: MaritalStatus, pageable: Pageable): Page<IdentityCard> = identityCardRepository.findByMaritalStatus(maritalStatus, pageable)

    override fun deleteIfExist(obj: IdentityCard) = identityCardRepository.findByCode(obj.code).ifPresent { hidden(it) }

    override fun saveOrUpdate(obj: IdentityCard): IdentityCard {
        identityCardRepository.findByCode(obj.code).ifPresent { obj.id = it.id }
        return  identityCardRepository.save(obj)
    }

    override fun save(obj: IdentityCard): IdentityCard {
        if(obj.code.isBlank()) obj.code = GeneratorNanoID.random()
        return super.save(obj)
    }

}