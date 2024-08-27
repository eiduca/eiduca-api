package app.com.eiduca.module.core.factory

import app.com.eiduca.module.core.builder.PersonBuilder
import app.com.eiduca.module.core.enums.Gender
import app.com.eiduca.module.core.enums.RegisterType
import app.com.eiduca.module.core.model.concrect.Person
import java.time.LocalDate

class PersonFactory {

    companion object{

        fun build(name: String, identityCardNumber: String) : Person =  PersonBuilder()
            .fullname("$name FULLNAME")
            .fullnameFather("$name FATHER")
            .fullnameMother("$name MOTHER")
            .username("${name.lowercase()}-slc")
            .email("${name.lowercase()}@eicore.com")
            .identityCardNumber(identityCardNumber)
            .password("12345678")
            .birthday(LocalDate.now().minusYears(20))
            .gender(Gender.MALE)
            .registerType(RegisterType.SYSTEM)
            .build()

    }
}