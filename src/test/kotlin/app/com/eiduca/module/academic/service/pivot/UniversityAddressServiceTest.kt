package app.com.eiduca.module.academic.service.pivot

import app.com.eiduca.module.academic.create.pivot.UniversityAddressCreate
import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.academic.repository.pivot.UniversityAddressRepository
import app.com.eiduca.module.core.common.general.CommonServiceTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of address of university service")
class UniversityAddressServiceTest: CommonServiceTest<UniversityAddress>() {
    @InjectMocks
    lateinit var universityAddressService: UniversityAddressService
    @Mock
    lateinit var universityAddressRepository: UniversityAddressRepository

    @BeforeEach
    fun setUp() {
        setUpCommon(universityAddressService, universityAddressRepository, UniversityAddressCreate.UNIVERSITY_ADDRESS_SAVE)
    }
}