package app.com.eiduca.module.academic.integration.pivot

import app.com.eiduca.annotation.EiducaTest
import app.com.eiduca.module.academic.create.pivot.InstitutionAddressCreate
import app.com.eiduca.module.academic.model.pivot.InstitutionAddress
import app.com.eiduca.module.academic.request.pivot.InstitutionAddressRequest
import app.com.eiduca.module.academic.service.concrete.InstitutionService
import app.com.eiduca.module.academic.service.pivot.InstitutionAddressService
import app.com.eiduca.module.core.common.general.PivotControllerItTest
import app.com.eiduca.module.core.service.concrect.AddressService
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiducaTest
@DisplayName("Test of address of institution integration")
class InstitutionAddressControllerIT (
    @Autowired val institutionAddressService: InstitutionAddressService,
    @Autowired val institutionService: InstitutionService,
    @Autowired val addressService: AddressService,
): PivotControllerItTest<InstitutionAddress>(
    institutionAddressService,
    InstitutionAddressCreate.INSTITUTION_ADDRESS_SAVE,
    "institution-address"
) {
    override fun requestModel(): InstitutionAddressRequest = model.toInstitutionAddressRequest()

    override fun runner(){
        model.institution = institutionService.saveOrUpdate(model.institution)
        model.address = addressService.saveOrUpdate(model.address)
        institutionAddressService.deleteIfExist(model)
    }
}