package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.create.PersonCreate
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of person repository")
class PersonRepositoryTest{

    @Autowired
    lateinit var personRepository: PersonRepository

    @Test
    @DisplayName("Create person when successful")
    fun save_WhenSuccessful(){
        val person = PersonCreate.PERSON_SAVE
        val personSave = personRepository.save(person);
        assertNotNull(personSave.id);
        assert(personSave == person)
    }

    @Test
    @DisplayName("Find person by username when successful")
    fun findByUsername_WhenSuccessful(){
        val person = PersonCreate.PERSON_SAVE
        personRepository.save(person)
        personRepository.findByUsername(person.username).ifPresentOrElse({
            assert(it.username == person.username)
        }, {throw NotFoundException("Person not found")})
    }

}