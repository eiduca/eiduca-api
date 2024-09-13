package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.request.AddressRequest
import app.com.eiduca.module.core.service.concrect.AddressService

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of address controller")
class AddressControllerTest: ConcreteControllerTest<Address, AddressRequest>() {
    @InjectMocks
    lateinit var addressController: AddressController
    @Mock
    lateinit var addressService: AddressService

    @BeforeEach
    fun setUp() {
        setUpConcrete(addressController, addressService, AddressCreate.ADDRESS_SAVE)
    }

    override fun createModel(): ResponseEntity<Address> = addressController.save(model.toRequest())

    override fun updateModel(): ResponseEntity<Address> = addressController.update(model.toRequest(), model.id)
}