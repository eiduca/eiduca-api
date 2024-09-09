package app.com.eiduca.module.core.builder

import app.com.eiduca.module.core.common.general.ConcreteBuilder
import app.com.eiduca.module.core.enums.MaritalStatus
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.model.concrect.Person
import java.time.LocalDate

class IdentityCardBuilder: ConcreteBuilder<IdentityCard>(){

    private var code: String = ""
    private var residential: String = ""
    private var naturalFrom: String = ""
    private var emittedIn: String = ""
    private var emittedAt: LocalDate =  LocalDate.now()
    private var validAt: LocalDate =  LocalDate.now()
    private var person: Person = Person()
    private var maritalStatus: MaritalStatus = MaritalStatus.SINGLE

    fun person(person: Person) = apply{ this.person = person }

    fun maritalStatus(maritalStatus: MaritalStatus) = apply{ this.maritalStatus = maritalStatus }

    fun code(code: String) = apply{ this.code = code }

    fun residential(residential: String) = apply{ this.residential = residential }

    fun naturalFrom(naturalFrom: String) = apply{ this.naturalFrom = naturalFrom }

    fun emittedIn(emittedIn: String) = apply{ this.emittedIn = emittedIn }

    fun emittedAt(emittedAt: LocalDate) = apply{ this.emittedAt = emittedAt }

    fun validAt(validAt: LocalDate) = apply{ this.validAt = validAt }

    override fun build(): IdentityCard {
        val identityCard = IdentityCard(code, residential, naturalFrom, emittedIn, emittedAt, validAt, maritalStatus, person)
        return withDefaultValues(identityCard)
    }

}