package app.com.eiduca.module.core.integration.pivot

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.core.common.general.PivotControllerItTest
import app.com.eiduca.module.core.create.pivot.PersonAddressCreate
import app.com.eiduca.module.core.model.pivot.PersonAddress
import app.com.eiduca.module.core.request.PersonAddressRequest
import app.com.eiduca.module.core.service.concrect.AddressService
import app.com.eiduca.module.core.service.concrect.PersonService
import app.com.eiduca.module.core.service.pivot.PersonAddressService
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of address of person")
class PersonAddressControllerIT(
    @Autowired val personAddressService: PersonAddressService,
    @Autowired val addressService: AddressService,
    @Autowired val personService: PersonService,
): PivotControllerItTest<PersonAddress>(
    personAddressService,
    PersonAddressCreate.PERSON_ADDRESS_UPDATE,
    "person-address"
) {

    override fun requestModel(): PersonAddressRequest = model.toRequest()

    override fun runner(){
        model.address = addressService.saveOrUpdate(model.address)
        model.person = personService.saveOrUpdate(model.person)
        personAddressService.deleteIfExist(model)
    }
}