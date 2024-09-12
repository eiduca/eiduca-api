package app.com.eiduca.module.academic.controller.pivot

import app.com.eiduca.module.academic.create.pivot.InstitutionAddressCreate
import app.com.eiduca.module.academic.model.pivot.InstitutionAddress
import app.com.eiduca.module.academic.request.pivot.InstitutionAddressRequest
import app.com.eiduca.module.academic.service.pivot.InstitutionAddressService
import app.com.eiduca.module.core.common.general.CommonControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of address of institution controller")
class InstitutionAddressControllerTest: CommonControllerTest<InstitutionAddress, InstitutionAddressRequest>() {
    @InjectMocks
    lateinit var institutionAddressController: InstitutionAddressController
    @Mock
    lateinit var institutionAddressService: InstitutionAddressService

    @BeforeEach
    fun setUp() {
        setUpCommon(institutionAddressController, institutionAddressService, InstitutionAddressCreate.INSTITUTION_ADDRESS_SAVE)
    }

    override fun createModel(): ResponseEntity<InstitutionAddress> = institutionAddressController.save(model.toInstitutionAddressRequest())

    override fun updateModel(): ResponseEntity<InstitutionAddress> = institutionAddressController.update(model.toInstitutionAddressRequest(), model.id)
}