package app.com.eiduca.module.core.seed

import app.com.eiduca.module.core.factory.IdentityCardFactory
import app.com.eiduca.module.core.model.concrect.IdentityCard

enum class IdentityCardSeed(val identityCard: IdentityCard) {
    PERSON_SUPER(IdentityCardFactory.build(PersonSeed.SUPER.person, "e10e5d3f")),
    PERSON_PERSON(IdentityCardFactory.build(PersonSeed.PERSON.person, "26612538")),
    PERSON_ROLE(IdentityCardFactory.build(PersonSeed.ROLE.person, "6ffa5f53")),
    PERSON_PERMISSION(IdentityCardFactory.build(PersonSeed.PERMISSION.person, "fe70427")),
    PERSON_IDENTITY_CARD(IdentityCardFactory.build(PersonSeed.IDENTITY_CARD.person, "b0316579"))
}