package app.com.eiduca.module.core.service.pivot

import app.com.eiduca.module.core.common.general.CommonServiceTest
import app.com.eiduca.module.core.create.pivot.PersonAddressCreate
import app.com.eiduca.module.core.model.pivot.PersonAddress
import app.com.eiduca.module.core.repository.pivot.PersonAddressRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of address of person service")
class PersonAddressServiceTest: CommonServiceTest<PersonAddress>() {
    @InjectMocks
    lateinit var personAddressService: PersonAddressService
    @Mock
    lateinit var personAddressRepository: PersonAddressRepository

    @BeforeEach
    fun setUp() {
        setUpCommon(personAddressService, personAddressRepository, PersonAddressCreate.PERSON_ADDRESS_SAVE)
    }
}