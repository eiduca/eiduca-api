package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.query.IdentityCardJPQL
import app.com.eiduca.module.core.common.general.ConcreteRepository
import app.com.eiduca.module.core.enums.MaritalStatus
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.model.concrect.Person
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.history.RevisionRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.Optional

@Repository
interface IdentityCardRepository: ConcreteRepository<IdentityCard>, RevisionRepository<IdentityCard, String, Long> {

    @Query(name = "ModelConcrete.findByCode")
    fun findByCode(code: String): Optional<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_PERSON)
    fun findByPerson(person: Person): List<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_PERSON, countName = IdentityCardJPQL.FIND_COUNT_PERSON)
    fun findByPerson(person: Person, page: Pageable): Page<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_RESIDENTIAL)
    fun findByResidential(residential: String): List<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_RESIDENTIAL, countName = IdentityCardJPQL.FIND_COUNT_RESIDENTIAL)
    fun findByResidential(residential: String, pageable: Pageable): Page<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_NATURAL_FROM)
    fun findByNaturalFrom(naturalFrom: String): List<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_NATURAL_FROM, countName = IdentityCardJPQL.FIND_COUNT_NATURAL_FROM)
    fun findByNaturalFrom(naturalFrom: String, pageable: Pageable): Page<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_EMITTED_FROM)
    fun findByEmittedFrom(emittedFrom: String): List<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_EMITTED_FROM, countName = IdentityCardJPQL.FIND_COUNT_EMITTED_FROM)
    fun findByEmittedFrom(emittedFrom: String, pageable: Pageable): Page<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_EMITTED_AT)
    fun findByEmittedAt(emittedAt: LocalDate): List<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_EMITTED_AT, countName = IdentityCardJPQL.FIND_COUNT_EMITTED_AT)
    fun findByEmittedAt(emittedAt: LocalDate, pageable: Pageable): Page<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_VALID_AT)
    fun findByValidAt(validAt: LocalDate): List<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_VALID_AT, countName = IdentityCardJPQL.FIND_COUNT_VALID_AT)
    fun findByValidAt(validAt: LocalDate, pageable: Pageable): Page<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_MARITAL_STATUS)
    fun findByMaritalStatus(maritalStatus: MaritalStatus): List<IdentityCard>

    @Query(name = IdentityCardJPQL.FIND_ALL_MARITAL_STATUS, countName = IdentityCardJPQL.FIND_COUNT_MARITAL_STATUS)
    fun findByMaritalStatus(maritalStatus: MaritalStatus, pageable: Pageable): Page<IdentityCard>
}