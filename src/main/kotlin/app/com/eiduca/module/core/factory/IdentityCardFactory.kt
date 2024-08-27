package app.com.eiduca.module.core.factory

import app.com.eiduca.module.core.builder.IdentityCardBuilder
import app.com.eiduca.module.core.enums.MaritalStatus
import app.com.eiduca.module.core.enums.RegisterType
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.model.concrect.Person
import java.time.LocalDate

class IdentityCardFactory {

    companion object{

        fun build(person: Person, registerType: RegisterType = RegisterType.SYSTEM) : IdentityCard {
            val now = LocalDate.now()
            return IdentityCardBuilder()
                .emittedIn("Luanda")
                .naturalFrom("Luanda")
                .residential("Antigos guerreiros")
                .emittedAt(now)
                .person(person)
                .validAt(now.plusDays(10))
                .maritalStatus(MaritalStatus.SINGLE)
                .registerType(registerType)
                .build()
        }
    }

}