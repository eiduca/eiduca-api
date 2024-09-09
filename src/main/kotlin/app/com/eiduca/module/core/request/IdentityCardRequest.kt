package app.com.eiduca.module.core.request

import app.com.eiduca.module.core.builder.IdentityCardBuilder
import app.com.eiduca.module.core.builder.PersonBuilder
import app.com.eiduca.module.core.enums.MaritalStatus
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.model.concrect.IdentityCard
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

data class IdentityCardRequest(
    @Schema(description = "Identity card person id")
    var person: String,
    @Schema(description = "Person's marital status [MARRIED, SINGLE, DIVORCED, WIDOWER]")
    var maritalStatus: MaritalStatus = MaritalStatus.SINGLE,
    @Schema(description = "Place of residence, where you live", example = "Blue school")
    var residential: String,
    @Schema(description = "Country or place where you were born", example = "Angolan")
    var naturalFrom: String,
    @Schema(description = "When the identity card was issued", example = "Luanda")
    var emittedIn: String,
    var emittedAt: LocalDate,
    var validAt: LocalDate,
): IConvertModel<IdentityCard> {

    override fun toModel() : IdentityCard = IdentityCardBuilder()
        .maritalStatus(maritalStatus)
        .residential(residential)
        .naturalFrom(naturalFrom)
        .emittedIn(emittedIn)
        .emittedAt(emittedAt)
        .validAt(validAt)
        .person(PersonBuilder().id(person).build())
        .build()
}