package app.com.eiduca.module.core.repository.pivot

import app.com.eiduca.module.core.create.pivot.PersonAddressCreate
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.repository.concrect.AddressRepository
import app.com.eiduca.module.core.repository.concrect.PersonRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.Pageable

@DataJpaTest
@DisplayName("Test of address of person repository")
class InstitutionAddressRepositoryTest{

    @Autowired lateinit var personAddressRepository: PersonAddressRepository

    @Autowired lateinit var personRepository: PersonRepository

    @Autowired lateinit var addressRepository: AddressRepository

    @Test
    @DisplayName("List pageable of address of person when successful")
    fun findAll_WhenSuccessful() {
        val personAddress = PersonAddressCreate.PERSON_ADDRESS_SAVE
        personAddress.person = personRepository.save(personAddress.person)
        personAddress.address = addressRepository.save(personAddress.address)
        personAddressRepository.save(personAddress)
        val response = personAddressRepository.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find address of person by id when successful")
    fun findById_WhenSuccessful() {
        assertDoesNotThrow {
            var personAddress = PersonAddressCreate.PERSON_ADDRESS_NOT_EXIST
            personAddress.person = personRepository.save(personAddress.person)
            personAddress.address = addressRepository.save(personAddress.address)
            personAddress = personAddressRepository.save(personAddress)
            personAddressRepository.findById(personAddress.id).ifPresentOrElse({
                assertEquals(it.id, personAddress.id)
            },{ throw NotFoundException("Not found address of person by id") })
        }
    }

    @Test
    @DisplayName("Create address of person when successful")
    fun save_WhenSuccessful(){
        assertDoesNotThrow {
            val personAddressCreate = PersonAddressCreate.PERSON_ADDRESS_SAVE
            personAddressCreate.person = personRepository.save(personAddressCreate.person)
            personAddressCreate.address = addressRepository.save(personAddressCreate.address)
            val personAddress = personAddressRepository.save(personAddressCreate)
            assertNotNull(personAddress.id)
            assert(personAddress == personAddressCreate)
        }
    }

    @Test
    @DisplayName("Delete address of person by id when successful")
    fun deleteById_WhenSuccessful() {
        assertDoesNotThrow {
            val personAddress = PersonAddressCreate.PERSON_ADDRESS_UPDATE
            personAddress.person = personRepository.save(personAddress.person)
            personAddress.address = addressRepository.save(personAddress.address)
            personAddressRepository.deleteById(personAddress.id)
            assertTrue(personAddressRepository.findById(personAddress.id).isEmpty)
        }
    }
}