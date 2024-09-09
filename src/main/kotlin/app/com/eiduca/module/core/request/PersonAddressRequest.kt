package app.com.eiduca.module.core.request

import app.com.eiduca.module.core.builder.AddressBuilder
import app.com.eiduca.module.core.builder.PersonBuilder
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.model.pivot.PersonAddress
import io.swagger.v3.oas.annotations.media.Schema

data class PersonAddressRequest(
    @Schema(description = "Person id")
    var person: String,
    @Schema(description = "Address id")
    var address: String,
): IConvertModel<PersonAddress> {

 override fun toModel(): PersonAddress {
     return PersonAddress(
         PersonBuilder().id(person).build(),
         AddressBuilder().id(address).build()
     )
 }

}