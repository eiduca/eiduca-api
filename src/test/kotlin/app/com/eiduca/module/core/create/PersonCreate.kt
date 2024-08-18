package app.com.eiduca.module.core.create

import app.com.eiduca.module.core.factory.PersonFactory
import app.com.eiduca.module.core.seed.PersonSeed
import app.com.eiduca.module.core.util.GeneratorUUID

class PersonCreate {

    companion object{

        val PERSON_SAVE = PersonSeed.PERSON.person

        val PERSON_UPDATE = PERSON_SAVE.apply { id = GeneratorUUID.v7toString() }

        val PERSON_NOT_EXIST = PersonFactory.build("TEST", "008610433SG0390")

    }

}