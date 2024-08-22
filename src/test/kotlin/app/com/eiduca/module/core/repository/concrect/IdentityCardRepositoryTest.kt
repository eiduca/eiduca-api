package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.create.concrete.IdentityCardCreate
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.Pageable

@DataJpaTest
@DisplayName("Test of identity cards repository")
class IdentityCardRepositoryTest{

    @Autowired lateinit var identityCardRepository: IdentityCardRepository

    @Autowired lateinit var personRepository: PersonRepository

    @Test
    @DisplayName("List pageable of identity cards when successful")
    fun findAll_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        identityCard.person = personRepository.save(identityCard.person)
        identityCardRepository.save(identityCard)
        val response = identityCardRepository.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find identity cards by id when successful")
    fun findById_WhenSuccessful() {
        assertDoesNotThrow {
            val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
            identityCard.person = personRepository.save(identityCard.person)
            val permission = identityCardRepository.save(identityCard)
            identityCardRepository.findById(permission.id).ifPresentOrElse({
                assertEquals(it.id, permission.id)
            },{throw NotFoundException("Not found identity card by id")})
        }
    }

    @Test
    @DisplayName("Find identity cards by name when successful")
    fun findByPerson_WhenSuccessful(){
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        identityCard.person = personRepository.save(identityCard.person)
        identityCardRepository.save(identityCard)
        identityCardRepository.findByPerson(identityCard.person).ifPresentOrElse({
            assert(it.person == identityCard.person)
        }, {throw NotFoundException("Not found identity card by name") })
    }

    @Test
    @DisplayName("Create identity card when successful")
    fun save_WhenSuccessful(){
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        identityCard.person = personRepository.save(identityCard.person)
        val identityCardSave = identityCardRepository.save(identityCard)
        assertNotNull(identityCardSave.id)
        assert(identityCardSave == identityCard)
    }

    @Test
    @DisplayName("Delete identity card by id when successful")
    fun deleteById_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_UPDATE
       assertDoesNotThrow {
            identityCardRepository.deleteById(identityCard.id)
           assertTrue(identityCardRepository.findById(identityCard.id).isEmpty)
        }
    }

}