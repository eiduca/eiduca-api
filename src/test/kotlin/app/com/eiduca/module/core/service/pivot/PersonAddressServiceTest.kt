package app.com.eiduca.module.core.service.pivot

import app.com.eiduca.module.core.create.pivot.PersonAddressCreate
import app.com.eiduca.module.core.repository.pivot.PersonAddressRepository
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@ExtendWith(SpringExtension::class)
@DisplayName("Test of address of person service")
class PersonAddressServiceTest {

    @InjectMocks
    lateinit var personAddressService: PersonAddressService

    @Mock
    lateinit var personAddressRepository: PersonAddressRepository

    @BeforeEach
    fun setUp() {
        val personAddress = PersonAddressCreate.PERSON_ADDRESS_SAVE
        val personAddresses = PageImpl(mutableListOf(personAddress))
        BDDMockito.`when`(personAddressRepository.findAll(Pageable.ofSize(15))).thenReturn(personAddresses)
        BDDMockito.`when`(personAddressRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(personAddress))
        BDDMockito.`when`(personAddressRepository.save(personAddress)).thenReturn(personAddress)
        BDDMockito.doNothing().`when`(personAddressRepository).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of address of person when successful")
    fun findAll_WhenSuccessful() {
        val response = personAddressService.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find address of person by id when successful")
    fun findById_WhenSuccessful() {
        val personAddress = PersonAddressCreate.PERSON_ADDRESS_SAVE
        assertDoesNotThrow {
            val response = personAddressService.findById(personAddress.id)
            assertEquals(response.id, personAddress.id)
        }
    }

    @Test
    @DisplayName("Create address of person when successful")
    fun save_WhenSuccessful() {
        val personAddress = PersonAddressCreate.PERSON_ADDRESS_SAVE
        assertDoesNotThrow {
            val response = personAddressService.save(personAddress)
            assertNotNull(response.id)
            assertEquals(response, personAddress)
        }
    }

    @Test
    @DisplayName("Update address of person when successful")
    fun update_WhenSuccessful() {
        val personAddress = PersonAddressCreate.PERSON_ADDRESS_UPDATE
        assertDoesNotThrow {
            val response = personAddressService.update(personAddress)
            assertNotNull(response.id)
            assert(response == personAddress)
        }
    }

    @Test
    @DisplayName("Delete address of person by id when successful")
    fun deleteById_WhenSuccessful() {
        val personAddress = PersonAddressCreate.PERSON_ADDRESS_UPDATE
        assertDoesNotThrow {
            personAddressService.deleteById(personAddress.id)
        }
    }

}