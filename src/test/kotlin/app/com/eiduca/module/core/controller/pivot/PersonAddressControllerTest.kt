package app.com.eiduca.module.core.controller.pivot

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.pivot.PersonAddressCreate
import app.com.eiduca.module.core.service.pivot.PersonAddressService
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of address of person controller")
class PersonAddressControllerTest {

    @InjectMocks
    lateinit var personAddressController: PersonAddressController

    @Mock
    lateinit var personAddressService: PersonAddressService

    @BeforeEach
    fun setUp() {
        val personAddress = PersonAddressCreate.PERSON_ADDRESS_SAVE
        val personAddresses = PageImpl(mutableListOf(personAddress))
        BDDMockito.`when`(personAddressService.findAll(Pageable.ofSize(15))).thenReturn(personAddresses)
        BDDMockito.`when`(personAddressService.findById(ArgumentMatchers.anyString())).thenReturn(personAddress)
        BDDMockito.`when`(personAddressService.save(personAddress)).thenReturn(personAddress)
        BDDMockito.doNothing().`when`(personAddressService).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of address of person when successful")
    fun findAll_WhenSuccessful() {
        val response = personAddressController.findAll(Pageable.ofSize(15))
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.isEmpty?.let { assertFalse(it) }
    }

    @Test
    @DisplayName("Find address of person by id when successful")
    fun findById_WhenSuccessful() {
        val personAddress = PersonAddressCreate.PERSON_ADDRESS_SAVE
        val response = personAddressController.findById(personAddress.id)
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.let { assert(personAddress == it) }
    }

    @Test
    @DisplayName("Create address of person when successful")
    fun save_WhenSuccessful() {
        val personAddress = PersonAddressCreate.PERSON_ADDRESS_SAVE
        val response = personAddressController.save(personAddress.toPersonAddressRequest())
        assertTrue(response.statusCode == ReturnStatus.CREATED)
        response.body?.let { assert(personAddress == it) }
    }

    @Test
    @DisplayName("Update address of person when successful")
    fun update_WhenSuccessful() {
        val personAddress = PersonAddressCreate.PERSON_ADDRESS_UPDATE
        val response = personAddressController.update(personAddress.toPersonAddressRequest(), personAddress.id)
        assertTrue(response.statusCode == ReturnStatus.UPDATED)
        response.body?.let { assert(personAddress == it) }
    }

    @Test
    @DisplayName("Delete address of person by id when successful")
    fun deleteById_WhenSuccessful() {
        val personAddress = PersonAddressCreate.PERSON_ADDRESS_UPDATE
        val response = personAddressController.deleteById(personAddress.id)
        assertTrue(response.statusCode == ReturnStatus.DELETED)
    }

}