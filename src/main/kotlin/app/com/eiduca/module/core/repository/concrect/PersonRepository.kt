package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.common.general.ConcreteRepository
import app.com.eiduca.module.core.enums.Gender
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.query.PersonJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.history.RevisionRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.Optional

@Repository
interface PersonRepository: ConcreteRepository<Person>, RevisionRepository<Person, String, Long>{
    @Query(name = PersonJPQL.FIND_BY_USERNAME)
    fun findByUsername(username: String): Optional<Person>

    @Query(name = PersonJPQL.FIND_BY_IDENTITY_CARD_NUMBER)
    fun findByIdentityCardNumber(identityCardNumber: String): Optional<Person>

    @Query(name = "ModelConcrete.findByEmail")
    fun findByEmail(email: String): Optional<Person>

    @Query(name = PersonJPQL.FIND_BY_BIRTHDAY, countName = PersonJPQL.FIND_COUNT_BIRTHDAY)
    fun findByBirthday(birthday: LocalDate, pageable: Pageable): Page<Person>

    @Query(name = PersonJPQL.FIND_BY_GENDER, countName = PersonJPQL.FIND_COUNT_GENDER)
    fun findByGender(gender: Gender, pageable: Pageable): Page<Person>
}