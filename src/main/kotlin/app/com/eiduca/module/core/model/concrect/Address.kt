package app.com.eiduca.module.core.model.concrect

import app.com.eiduca.module.core.common.general.ConcreteModel
import app.com.eiduca.module.core.interfaces.IUniqueAttributeModifier
import app.com.eiduca.module.core.request.AddressRequest
import app.com.eiduca.module.core.util.GeneratorNanoID
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.PrePersist
import jakarta.persistence.Table

@Entity
@Table(name = "tb_addresses")
class Address (
    @Column(unique = true)
    var code: String,
    var streetName: String,
    var houseNumber: String,
    var neighborhood: String,
    var city: String,
    var province: String,
    var country: String,
    @Column(nullable = true)
    var postalCode: String? = null,
    @Column(nullable = true)
    var latitude: Double? = null,
    @Column(nullable = true)
    var longitude: Double? = null,
): ConcreteModel(), IUniqueAttributeModifier{

    constructor(): this("","","","","","","")

    @PrePersist
    fun setUpAddress(){
        code = GeneratorNanoID.random()
    }

    override fun updateUniqueAttributes() {
        code += nanoId()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (streetName != other.streetName) return false
        if (houseNumber != other.houseNumber) return false
        if (neighborhood != other.neighborhood) return false
        if (city != other.city) return false
        if (province != other.province) return false
        if (country != other.country) return false
        if (postalCode != other.postalCode) return false
        if (latitude != other.latitude) return false
        if (longitude != other.longitude) return false
        return true
    }

    override fun hashCode(): Int {
        var result = streetName.hashCode()
        result = 31 * result + houseNumber.hashCode()
        result = 31 * result + neighborhood.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + province.hashCode()
        result = 31 * result + country.hashCode()
        result = 31 * result + (postalCode?.hashCode() ?: 0)
        result = 31 * result + (latitude?.hashCode() ?: 0)
        result = 31 * result + (longitude?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Address(${setToString("code='$code', streetName='$streetName', houseNumber='$houseNumber', neighborhood='$neighborhood', city='$city', province='$province', country='$country', postalCode=$postalCode, latitude=$latitude, longitude=$longitude")})"
    }

    fun toAddressRequest(): AddressRequest = AddressRequest(streetName, houseNumber, neighborhood, city, province, country, postalCode, latitude, longitude)


}