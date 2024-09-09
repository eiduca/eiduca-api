package app.com.eiduca.module.academic.repository.pivot

import app.com.eiduca.module.academic.create.pivot.InstitutionAddressCreate
import app.com.eiduca.module.academic.model.pivot.InstitutionAddress
import app.com.eiduca.module.academic.repository.concrete.InstitutionRepository
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
@DisplayName("Test of address of institution repository")
class InstitutionAddressRepositoryTest{

    @Autowired
    lateinit var institutionAddressRepository: InstitutionAddressRepository

    @Autowired
    lateinit var institutionRepository: InstitutionRepository

    @Autowired
    lateinit var universityRepository: UniversityRepository

    @Autowired
    lateinit var addressRepository: AddressRepository

    @Test
    @DisplayName("List pageable of address of institution when successful")
    fun findAll_WhenSuccessful() {
        createInstitutionAddress(InstitutionAddressCreate.INSTITUTION_ADDRESS_SAVE)
        val response = institutionAddressRepository.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find address of institution by id when successful")
    fun findById_WhenSuccessful() {
        assertDoesNotThrow {
            val institutionAddress = createInstitutionAddress(InstitutionAddressCreate.INSTITUTION_ADDRESS_NOT_EXIST)
            institutionAddressRepository.findById(institutionAddress.id).ifPresentOrElse({
                assertEquals(it.id, institutionAddress.id)
            },{ throw NotFoundException("Not found address of institution by id") })
        }
    }

    @Test
    @DisplayName("Create address of institution when successful")
    fun save_WhenSuccessful(){
        assertDoesNotThrow {
            val institutionAddressCreate = InstitutionAddressCreate.INSTITUTION_ADDRESS_SAVE
            val institutionAddress = createInstitutionAddress(institutionAddressCreate)
            assertNotNull(institutionAddress.id)
            assert(institutionAddress == institutionAddressCreate)
        }
    }

    @Test
    @DisplayName("Delete address of institution by id when successful")
    fun deleteById_WhenSuccessful() {
        assertDoesNotThrow {
            val institutionAddress = createInstitutionAddress(InstitutionAddressCreate.INSTITUTION_ADDRESS_UPDATE)
            institutionAddressRepository.deleteById(institutionAddress.id)
            assertTrue(institutionAddressRepository.findById(institutionAddress.id).isEmpty)
        }
    }

    fun createInstitutionAddress(institutionAddress: InstitutionAddress): InstitutionAddress{
        institutionAddress.institution.university = universityRepository.save(institutionAddress.institution.university)
        institutionAddress.institution = institutionRepository.save(institutionAddress.institution)
        institutionAddress.address = addressRepository.save(institutionAddress.address)
        return institutionAddressRepository.save(institutionAddress)
    }

}