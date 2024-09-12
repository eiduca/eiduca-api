package app.com.eiduca.module.academic.service.pivot

import app.com.eiduca.module.academic.create.pivot.InstitutionAddressCreate
import app.com.eiduca.module.academic.model.pivot.InstitutionAddress
import app.com.eiduca.module.academic.repository.pivot.InstitutionAddressRepository
import app.com.eiduca.module.core.common.general.CommonServiceTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of address of institution service")
class InstitutionAddressServiceTest: CommonServiceTest<InstitutionAddress>() {
    @InjectMocks
    lateinit var institutionAddressService: InstitutionAddressService
    @Mock
    lateinit var institutionAddressRepository: InstitutionAddressRepository

    @BeforeEach
    fun setUpInstitutionAddress() {
        setUpCommon(institutionAddressService, institutionAddressRepository, InstitutionAddressCreate.INSTITUTION_ADDRESS_SAVE)
    }
}