package app.com.eiduca.module.academic.repository.pivot

import app.com.eiduca.module.academic.create.pivot.UniversityAddressCreate
import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.academic.repository.concrete.UniversityRepository
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.repository.concrect.AddressRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.Pageable

@DataJpaTest
@DisplayName("Test of address of university repository")
class UniversityAddressRepositoryTest{

    @Autowired
    lateinit var universityAddressRepository: UniversityAddressRepository

    @Autowired
    lateinit var universityRepository: UniversityRepository

    @Autowired
    lateinit var addressRepository: AddressRepository

    @Test
    @DisplayName("List pageable of address of university when successful")
    fun findAll_WhenSuccessful() {
        val universityAddress = UniversityAddressCreate.UNIVERSITY_ADDRESS_SAVE
        universityAddress.university = universityRepository.save(universityAddress.university)
        universityAddress.address = addressRepository.save(universityAddress.address)
        universityAddressRepository.save(universityAddress)
        val response = universityAddressRepository.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find address of university by id when successful")
    fun findById_WhenSuccessful() {
        assertDoesNotThrow {
            var universityAddress = UniversityAddressCreate.UNIVERSITY_ADDRESS_NOT_EXIST
            universityAddress.university = universityRepository.save(universityAddress.university)
            universityAddress.address = addressRepository.save(universityAddress.address)
            universityAddress = universityAddressRepository.save(universityAddress)
            universityAddressRepository.findById(universityAddress.id).ifPresentOrElse({
                assertEquals(it.id, universityAddress.id)
            },{ throw NotFoundException("Not found address of university by id") })
        }
    }

    @Test
    @DisplayName("Create address of university when successful")
    fun save_WhenSuccessful(){
        assertDoesNotThrow {
            val universityAddressCreate = UniversityAddressCreate.UNIVERSITY_ADDRESS_SAVE
            val universityAddress = createUniversityAddress(universityAddressCreate)
            assertNotNull(universityAddress.id)
            assert(universityAddress == universityAddressCreate)
        }
    }

    @Test
    @DisplayName("Delete address of university by id when successful")
    fun deleteById_WhenSuccessful() {
        assertDoesNotThrow {
            val universityAddress = createUniversityAddress(UniversityAddressCreate.UNIVERSITY_ADDRESS_UPDATE)
            universityAddressRepository.deleteById(universityAddress.id)
            assertTrue(universityAddressRepository.findById(universityAddress.id).isEmpty)
        }
    }

    fun createUniversityAddress(universityAddress: UniversityAddress): UniversityAddress{
        universityAddress.university = universityRepository.save(universityAddress.university)
        universityAddress.address = addressRepository.save(universityAddress.address)
        return universityAddressRepository.save(universityAddress)
    }
}