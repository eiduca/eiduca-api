package app.com.eiduca.module.core.integration.concrete

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.request.AddressRequest
import app.com.eiduca.module.core.service.concrect.AddressService
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test integration of address")
class AddressControllerIT(
    @Autowired val addressService: AddressService
): ConcreteControllerItTest<Address>(
    addressService,
    AddressCreate.ADDRESS_SAVE,
    "addresses"
) {
    override fun requestModel(): AddressRequest = model.toRequest()
}