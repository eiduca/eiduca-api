package app.com.eiduca.module.academic.integration.pivot

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.pivot.UniversityAddressCreate
import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.academic.request.pivot.UniversityAddressRequest
import app.com.eiduca.module.academic.service.concrete.UniversityService
import app.com.eiduca.module.academic.service.pivot.UniversityAddressService
import app.com.eiduca.module.core.common.general.PivotControllerItTest
import app.com.eiduca.module.core.service.concrect.AddressService
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test of address of university integration")
class UniversityAddressControllerIT (
    @Autowired val universityAddressService: UniversityAddressService,
    @Autowired val universityService: UniversityService,
    @Autowired val addressService: AddressService,
): PivotControllerItTest<UniversityAddress>(
    universityAddressService,
    UniversityAddressCreate.UNIVERSITY_ADDRESS_SAVE,
    "university-address"
) {
    override fun requestModel(): UniversityAddressRequest = model.toUniversityAddressRequest()

    override fun runner(){
        model.university = universityService.saveOrUpdate(model.university)
        model.address = addressService.saveOrUpdate(model.address)
        universityAddressService.deleteIfExist(model)
    }
}