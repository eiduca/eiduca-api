package app.com.eiduca.module.academic.controller.pivot

import app.com.eiduca.module.academic.create.pivot.UniversityAddressCreate
import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.academic.request.pivot.UniversityAddressRequest
import app.com.eiduca.module.academic.service.pivot.UniversityAddressService
import app.com.eiduca.module.core.common.general.CommonControllerTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of address of university controller")
class UniversityAddressControllerTest: CommonControllerTest<UniversityAddress, UniversityAddressRequest>() {
    @InjectMocks
    lateinit var universityAddressController: UniversityAddressController
    @Mock
    lateinit var universityAddressService: UniversityAddressService

    @BeforeEach
    fun setUp() {
        setUpCommon(universityAddressController, universityAddressService, UniversityAddressCreate.UNIVERSITY_ADDRESS_SAVE)
    }

    override fun createModel(): ResponseEntity<UniversityAddress> = universityAddressController.save(model.toUniversityAddressRequest())

    override fun updateModel(): ResponseEntity<UniversityAddress> = universityAddressController.update(model.toUniversityAddressRequest(), model.id)
}