package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.seed.AddressSeed
import app.com.eiduca.module.core.service.concrect.AddressService
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of address controller")
class AddressControllerTest {

    @InjectMocks
    lateinit var addressController: AddressController

    @Mock
    lateinit var addressService: AddressService

    @BeforeEach
    fun setUp() {
        val address = AddressCreate.ADDRESS_SAVE
        val addresses = PageImpl(AddressSeed.entries.map { it.address })
        BDDMockito.`when`(addressService.findAll(Pageable.ofSize(15))).thenReturn(addresses)
        BDDMockito.`when`(addressService.findById(ArgumentMatchers.anyString())).thenReturn(address)
        BDDMockito.`when`(addressService.save(address)).thenReturn(address)
        BDDMockito.doNothing().`when`(addressService).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of addresses when successful")
    fun findAll_WhenSuccessful() {
        val response = addressController.findAll(Pageable.ofSize(15))
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.isEmpty?.let { assertFalse(it) }
    }

    @Test
    @DisplayName("Find address by id when successful")
    fun findById_WhenSuccessful() {
        val address = AddressCreate.ADDRESS_SAVE
        val response = addressController.findById(address.id)
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.let { assert(address == it) }
    }

    @Test
    @DisplayName("Create address when successful")
    fun save_WhenSuccessful() {
        val address = AddressCreate.ADDRESS_SAVE
        val response = addressController.save(address.toAddressRequest())
        assertTrue(response.statusCode == ReturnStatus.CREATED)
        response.body?.let { assert(address == it) }
    }

    @Test
    @DisplayName("Update address when successful")
    fun update_WhenSuccessful() {
        val address = AddressCreate.ADDRESS_UPDATE
        val response = addressController.update(address.toAddressRequest(), address.id)
        assertTrue(response.statusCode == ReturnStatus.UPDATED)
        response.body?.let { assert(address == it) }
    }

    @Test
    @DisplayName("Delete address by id when successful")
    fun deleteById_WhenSuccessful() {
        val address = AddressCreate.ADDRESS_UPDATE
        val response = addressController.deleteById(address.id)
        assertTrue(response.statusCode == ReturnStatus.DELETED)
    }
}