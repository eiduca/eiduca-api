package app.com.eiduca.module.academic.request

import app.com.eiduca.module.academic.builder.InstitutionBuilder
import app.com.eiduca.module.academic.model.pivot.InstitutionAddress
import app.com.eiduca.module.core.builder.AddressBuilder
import app.com.eiduca.module.core.interfaces.IConvertModel
import io.swagger.v3.oas.annotations.media.Schema

data class InstitutionAddressRequest (
    @Schema(description = "Institution id")
    var institution: String,
    @Schema(description = "Address id")
    var address: String,
): IConvertModel<InstitutionAddress> {

    override fun toModel(): InstitutionAddress {
        return InstitutionAddress(
            InstitutionBuilder().id(institution).build(),
            AddressBuilder().id(address).build()
        )
    }

}