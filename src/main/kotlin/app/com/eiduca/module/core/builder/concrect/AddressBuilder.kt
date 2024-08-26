package app.com.eiduca.module.core.builder.concrect

import app.com.eiduca.module.core.common.ConcreteBuilder
import app.com.eiduca.module.core.model.concrect.Address
import app.com.eiduca.module.core.model.concrect.Role

class AddressBuilder: ConcreteBuilder<Address>(){

    private var streetName: String = ""
    private var houseNumber: String = ""
    private var neighborhood: String = ""
    private var city: String = ""
    private var stateOrProvince: String = ""
    private var country: String = ""
    private var postalCode: String? = null
    private var latitude: Double? = null
    private var longitude: Double? = null

    fun streetName(streetName: String) = apply{ this.streetName = streetName }

    fun houseNumber(houseNumber: String) = apply{ this.houseNumber = houseNumber }

    fun neighborhood(neighborhood: String) = apply{ this.neighborhood = neighborhood }

    fun city(city: String) = apply{ this.city = city }

    fun stateOrProvince(stateOrProvince: String) = apply{ this.stateOrProvince = stateOrProvince }

    fun country(country: String) = apply{ this.country = country }

    fun postalCode(postalCode: String? = null) = apply{ this.postalCode = postalCode }

    fun latitude(latitude: Double? = null) = apply{ this.latitude = latitude }

    fun longitude(longitude: Double? = null) = apply{ this.longitude = longitude }

    override fun build(): Address {
        val address = Address(streetName, houseNumber, neighborhood, city, stateOrProvince, country,postalCode, latitude, longitude)
        return withDefaultValues(address)
    }
}