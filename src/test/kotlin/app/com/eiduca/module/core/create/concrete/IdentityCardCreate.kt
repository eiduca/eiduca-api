package app.com.eiduca.module.core.create.concrete

import app.com.eiduca.module.core.factory.concrete.IdentityCardFactory
import app.com.eiduca.module.core.factory.concrete.PermissionFactory
import app.com.eiduca.module.core.seed.concrete.IdentityCardSeed
import app.com.eiduca.module.core.seed.concrete.PermissionSeed
import app.com.eiduca.module.core.util.GeneratorUUID

class IdentityCardCreate {

    companion object{

        val IDENTITY_CARD_SAVE = IdentityCardSeed.PERSON_SUPER.identityCard.apply { person = PersonCreate.PERSON_NOT_EXIST }

        val IDENTITY_CARD_UPDATE = IDENTITY_CARD_SAVE.apply { id = GeneratorUUID.v7toString() }

        val IDENTITY_CARD_NOT_EXIST = IdentityCardFactory.build(PersonCreate.PERSON_NOT_EXIST)

    }

}