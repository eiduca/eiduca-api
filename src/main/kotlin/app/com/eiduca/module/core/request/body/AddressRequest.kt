package app.com.eiduca.module.core.request.body

import app.com.eiduca.module.core.builder.concrect.AddressBuilder
import app.com.eiduca.module.core.builder.concrect.RoleBuilder
import app.com.eiduca.module.core.model.concrect.Address

class AddressRequest(
    var streetName: String,
    var houseNumber: String,
    var neighborhood: String,
    var city: String,
    var stateOrProvince: String,
    var country: String,
    var postalCode: String? = null,
    var latitude: Double? = null,
    var longitude: Double? = null,
) {

    fun toAddress() : Address = AddressBuilder()
        .streetName(streetName)
        .houseNumber(houseNumber)
        .neighborhood(neighborhood)
        .city(city)
        .stateOrProvince(stateOrProvince)
        .country(country)
        .postalCode(postalCode)
        .latitude(latitude)
        .longitude(longitude)
        .build()
}