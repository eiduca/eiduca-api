package app.com.eiduca.module.core.seed.concrete

import app.com.eiduca.module.core.factory.concrete.IdentityCardFactory
import app.com.eiduca.module.core.model.concrect.IdentityCard

enum class IdentityCardSeed(val identityCard: IdentityCard) {
    PERSON_SUPER(IdentityCardFactory.build(PersonSeed.SUPER.person)),
    PERSON_PERSON(IdentityCardFactory.build(PersonSeed.PERSON.person)),
    PERSON_ROLE(IdentityCardFactory.build(PersonSeed.ROLE.person)),
    PERSON_PERMISSION(IdentityCardFactory.build(PersonSeed.PERMISSION.person)),
    PERSON_IDENTITY_CARD(IdentityCardFactory.build(PersonSeed.IDENTITY_CARD.person))
}