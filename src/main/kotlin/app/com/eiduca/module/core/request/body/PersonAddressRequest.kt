package app.com.eiduca.module.core.request.body

import app.com.eiduca.module.core.builder.AddressBuilder
import app.com.eiduca.module.core.builder.PersonBuilder
import app.com.eiduca.module.core.model.pivot.PersonAddress
import io.swagger.v3.oas.annotations.media.Schema

class PersonAddressRequest(
    @Schema(description = "Person id")
    var person: String,
    @Schema(description = "Address id")
    var address: String,
) {

 fun toPersonAddress(): PersonAddress {
     return PersonAddress(
         PersonBuilder().id(person).build(),
         AddressBuilder().id(address).build()
     )
 }

}