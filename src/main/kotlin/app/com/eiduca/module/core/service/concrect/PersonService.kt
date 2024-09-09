package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.general.ConcreteService
import app.com.eiduca.module.core.enums.Gender
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.repository.concrect.PersonRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PersonService(
    val personRepository: PersonRepository
): ConcreteService<Person>(personRepository) {

    fun findByUsername(username: String): Person = personRepository.findByUsername(username).orElseThrow { NotFoundException("Not found person by username [$username]") }

    fun findByEmail(email: String): Person = personRepository.findByEmail(email).orElseThrow { NotFoundException("Not found person by email [$email]") }

    fun findByGender(gender: Gender, pageable: Pageable): Page<Person> = personRepository.findByGender(gender, pageable)

    fun findByBirthday(birthday: LocalDate, pageable: Pageable): Page<Person> = personRepository.findByBirthday(birthday, pageable)

    override fun saveOrUpdate(obj: Person): Person {
        personRepository.findByUsername(obj.username).ifPresent { obj.id = it.id }
        return  personRepository.save(obj)
    }
}