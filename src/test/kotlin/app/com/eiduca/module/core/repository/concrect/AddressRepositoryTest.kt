package app.com.eiduca.module.core.repository.concrect

import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.Pageable

@DataJpaTest
@DisplayName("Test of address repository")
class AddressRepositoryTest{

    @Autowired
    lateinit var addressRepository: AddressRepository

    @Test
    @DisplayName("List pageable of address when successful")
    fun findAll_WhenSuccessful() {
        addressRepository.save(AddressCreate.ADDRESS_SAVE)
        val response = addressRepository.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find address by id when successful")
    fun findById_WhenSuccessful() {
        assertDoesNotThrow {
            val address = addressRepository.save(AddressCreate.ADDRESS_NOT_EXIST)
            addressRepository.findById(address.id).ifPresentOrElse({
                assertEquals(it.id, address.id)
            },{throw NotFoundException("Not found address by id") })
        }
    }

    @Test
    @DisplayName("Create address when successful")
    fun save_WhenSuccessful(){
        val address = AddressCreate.ADDRESS_SAVE
        val addressSave = addressRepository.save(address)
        assertNotNull(addressSave.id)
        assert(addressSave == address)
    }

    @Test
    @DisplayName("Delete address by id when successful")
    fun deleteById_WhenSuccessful() {
        val address = AddressCreate.ADDRESS_UPDATE
        assertDoesNotThrow {
            addressRepository.deleteById(address.id)
            assertTrue(addressRepository.findById(address.id).isEmpty)
        }
    }
}