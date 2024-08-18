package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.repository.concrect.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
    val personRepository: PersonRepository
): ConcreteService<Person>(personRepository) {

    fun findByUsername(username: String): Person = personRepository.findByUsername(username).orElseThrow { NotFoundException("Not found person by username [$username]") }

    fun saveOrUpdate(person: Person): Person {
        personRepository.findByUsername(person.username).ifPresent {
            person.id = it.id
        }
        return  personRepository.save(person)
    }

}