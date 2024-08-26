package app.com.eiduca.module.core.create.concrete

import app.com.eiduca.module.core.factory.concrete.AddressFactory
import app.com.eiduca.module.core.seed.concrete.AddressSeed
import app.com.eiduca.module.core.util.GeneratorUUID

class AddressCreate {

    companion object{

        val ADDRESS_SAVE = AddressSeed.DEFAULT.address

        val ADDRESS_UPDATE = ADDRESS_SAVE.apply { id = GeneratorUUID.v7toString() }

        val ADDRESS_NOT_EXIST = AddressFactory.build()

    }

}