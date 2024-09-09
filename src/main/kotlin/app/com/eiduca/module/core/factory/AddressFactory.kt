package app.com.eiduca.module.core.factory

import app.com.eiduca.module.core.builder.AddressBuilder
import app.com.eiduca.module.core.enums.RegisterType
import app.com.eiduca.module.core.model.concrect.Address

class AddressFactory {

    companion object{

        fun build(code: String) : Address = AddressBuilder()
            .code(code)
            .streetName("Project New Life")
            .city("Project New Life")
            .postalCode("0000-000")
            .country("Angolan")
            .stateOrProvince("Luanda")
            .neighborhood("Principal")
            .houseNumber("24")
            .latitude(0.0)
            .longitude(0.0)
            .registerType(RegisterType.SYSTEM)
            .build()

    }
}