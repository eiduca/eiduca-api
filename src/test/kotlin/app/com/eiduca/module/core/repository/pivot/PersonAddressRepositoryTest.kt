package app.com.eiduca.module.core.repository.pivot

import app.com.eiduca.module.core.common.general.CommonRepositoryTest
import app.com.eiduca.module.core.create.pivot.PersonAddressCreate
import app.com.eiduca.module.core.model.pivot.PersonAddress
import app.com.eiduca.module.core.repository.concrect.AddressRepository
import app.com.eiduca.module.core.repository.concrect.PersonRepository
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@DisplayName("Test of address of person repository")
class PersonAddressRepositoryTest(
    @Autowired val personAddressRepository: PersonAddressRepository,
    @Autowired val personRepository: PersonRepository,
    @Autowired val addressRepository: AddressRepository,
): CommonRepositoryTest<PersonAddress>(
    personAddressRepository,
    PersonAddressCreate.PERSON_ADDRESS_SAVE
){
    override fun runner() {
        model.person = personRepository.save(model.person)
        model.address = addressRepository.save(model.address)
    }
}