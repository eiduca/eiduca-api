package app.com.eiduca.module.core.create.pivot

import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.create.concrete.PersonCreate
import app.com.eiduca.module.core.model.pivot.PersonAddress
import app.com.eiduca.module.core.util.GeneratorUUID

class PersonAddressCreate {

    companion object{

        val PERSON_ADDRESS_SAVE = PersonAddress(
            PersonCreate.PERSON_UPDATE,
            AddressCreate.ADDRESS_UPDATE
        )

        val PERSON_ADDRESS_UPDATE = PERSON_ADDRESS_SAVE.apply { id = GeneratorUUID.v7toString() }

        val PERSON_ADDRESS_NOT_EXIST = PersonAddress(
            PersonCreate.PERSON_NOT_EXIST,
            AddressCreate.ADDRESS_NOT_EXIST
        )

    }

}