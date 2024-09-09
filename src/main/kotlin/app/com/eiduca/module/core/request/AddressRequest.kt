package app.com.eiduca.module.core.request

import app.com.eiduca.module.core.builder.AddressBuilder
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.model.concrect.Address

data class AddressRequest(
    var streetName: String,
    var houseNumber: String,
    var neighborhood: String,
    var city: String,
    var stateOrProvince: String,
    var country: String,
    var postalCode: String? = null,
    var latitude: Double? = null,
    var longitude: Double? = null,
): IConvertModel<Address> {

    override fun toModel() : Address = AddressBuilder()
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