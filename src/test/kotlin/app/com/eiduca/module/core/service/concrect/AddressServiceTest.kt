package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.repository.concrect.AddressRepository
import app.com.eiduca.module.core.seed.AddressSeed
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
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
@DisplayName("Test of address service")
class AddressServiceTest {

    @InjectMocks
    lateinit var addressService: AddressService

    @Mock
    lateinit var addressRepository: AddressRepository

    @BeforeEach
    fun setUp() {
        val address = AddressCreate.ADDRESS_SAVE
        val addresses = PageImpl(AddressSeed.entries.map { it.address })
        BDDMockito.`when`(addressRepository.findAll(Pageable.ofSize(15))).thenReturn(addresses)
        BDDMockito.`when`(addressRepository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(address))
        BDDMockito.`when`(addressRepository.save(address)).thenReturn(address)
        BDDMockito.doNothing().`when`(addressRepository).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of addresses when successful")
    fun findAll_WhenSuccessful() {
        val response = addressService.findAll(Pageable.ofSize(15))
        assertFalse(response.isEmpty)
    }

    @Test
    @DisplayName("Find address by id when successful")
    fun findById_WhenSuccessful() {
        val address = AddressCreate.ADDRESS_SAVE
        assertDoesNotThrow {
            val response = addressService.findById(address.id)
            assertEquals(response.id, address.id)
        }
    }

    @Test
    @DisplayName("Create address when successful")
    fun save_WhenSuccessful() {
        val address = AddressCreate.ADDRESS_SAVE
        assertDoesNotThrow {
            val response = addressService.save(address)
            assertNotNull(response.id)
            assertEquals(response, address)
        }
    }

    @Test
    @DisplayName("Update address when successful")
    fun update_WhenSuccessful() {
        val address = AddressCreate.ADDRESS_UPDATE
        assertDoesNotThrow {
            val response = addressService.update(address)
            assertNotNull(response.id)
            assert(response == address)
        }
    }

    @Test
    @DisplayName("Delete address by id when successful")
    fun deleteById_WhenSuccessful() {
        val address = AddressCreate.ADDRESS_UPDATE
        assertDoesNotThrow {
            addressService.deleteById(address.id)
        }
    }

}