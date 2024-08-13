package app.com.eiduca.module.core.component

import app.com.eiduca.module.core.model.concrect.Person
import app.com.eiduca.module.core.seed.PersonSeed
import app.com.eiduca.module.core.service.concrect.PersonService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DatabaseRunner(
    val personService: PersonService,
): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val persons: MutableList<Person> = mutableListOf()
        PersonSeed.entries.forEach { persons.addLast(personService.saveOrUpdate(it.person)) }
    }

}