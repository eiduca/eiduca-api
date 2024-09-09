package app.com.eiduca.module.academic.request

import app.com.eiduca.module.academic.builder.UniversityBuilder
import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.core.builder.AddressBuilder
import app.com.eiduca.module.core.interfaces.IConvertModel
import io.swagger.v3.oas.annotations.media.Schema

data class UniversityAddressRequest (
    @Schema(description = "University id")
    var university: String,
    @Schema(description = "Address id")
    var address: String,
): IConvertModel<UniversityAddress> {

   override fun toModel(): UniversityAddress = UniversityAddress(
       UniversityBuilder().id(university).build(),
       AddressBuilder().id(address).build()
   )
}