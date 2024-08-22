package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.create.concrete.PersonCreate
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.Pageable

@DataJpaTest
@DisplayName("Test of person repository")
class PersonRepositoryTest{

    @Autowired
    lateinit var personRepository: PersonRepository

    @Test
    @DisplayName("List pageable of persons when successful")
    fun findAll_WhenSuccessful() {
        personRepository.save(PersonCreate.PERSON_SAVE)
        val response = personRepository.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find person by id when successful")
    fun findById_WhenSuccessful() {
        assertDoesNotThrow {
            val person = personRepository.save(PersonCreate.PERSON_NOT_EXIST)
            personRepository.findById(person.id).ifPresentOrElse({
                assertEquals(it.id, person.id)
            },{throw NotFoundException("Not found person by id")})
        }
    }

    @Test
    @DisplayName("Find person by username when successful")
    fun findByUsername_WhenSuccessful(){
        val person = PersonCreate.PERSON_SAVE
        personRepository.save(person)
        personRepository.findByUsername(person.username).ifPresentOrElse({
            assert(it.username == person.username)
        }, {throw NotFoundException("Not found person by username")})
    }

    @Test
    @DisplayName("Create person when successful")
    fun save_WhenSuccessful(){
        val person = PersonCreate.PERSON_SAVE
        val personSave = personRepository.save(person);
        assertNotNull(personSave.id);
        assert(personSave == person)
    }

    @Test
    @DisplayName("Delete person by id when successful")
    fun deleteById_WhenSuccessful() {
        val person = PersonCreate.PERSON_SAVE
        assertDoesNotThrow {
            personRepository.deleteById(person.id)
            assertTrue(personRepository.findById(person.id).isEmpty)
        }
    }
}