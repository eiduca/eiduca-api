package app.com.eiduca.module.core.controller.pivot

import app.com.eiduca.module.core.common.general.CommonControllerTest
import app.com.eiduca.module.core.create.pivot.PersonAddressCreate
import app.com.eiduca.module.core.model.pivot.PersonAddress
import app.com.eiduca.module.core.request.PersonAddressRequest
import app.com.eiduca.module.core.service.pivot.PersonAddressService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of address of person controller")
class PersonAddressControllerTest: CommonControllerTest<PersonAddress, PersonAddressRequest>() {
    @InjectMocks
    lateinit var personAddressController: PersonAddressController
    @Mock
    lateinit var personAddressService: PersonAddressService

    @BeforeEach
    fun setUp() {
        setUpCommon(personAddressController, personAddressService, PersonAddressCreate.PERSON_ADDRESS_SAVE)
    }

    override fun createModel(): ResponseEntity<PersonAddress> = personAddressController.save(model.toRequest())

    override fun updateModel(): ResponseEntity<PersonAddress> = personAddressController.update(model.toRequest(), model.id)
}