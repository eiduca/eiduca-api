package app.com.eiduca.module.core.factory.concrete

import app.com.eiduca.module.core.builder.concrect.AddressBuilder
import app.com.eiduca.module.core.enums.RegisterType
import app.com.eiduca.module.core.model.concrect.Address

class AddressFactory {

    companion object{

        fun build() : Address = AddressBuilder()
            .streetName("Project New Life")
            .city("Project New Life")
            .postalCode("0000-000")
            .country("Angolan")
            .stateOrProvince("Luanda")
            .neighborhood("Principal")
            .houseNumber("24")
            .registerType(RegisterType.SYSTEM)
            .build()

    }
}