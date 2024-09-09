package app.com.eiduca.module.academic.create.pivot

import app.com.eiduca.module.academic.create.concrete.InstitutionCreate
import app.com.eiduca.module.academic.model.pivot.InstitutionAddress
import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.util.GeneratorUUID

class InstitutionAddressCreate {

    companion object{

        val INSTITUTION_ADDRESS_SAVE = InstitutionAddress(
            InstitutionCreate.INSTITUTION_UPDATE,
            AddressCreate.ADDRESS_UPDATE
        )

        val INSTITUTION_ADDRESS_UPDATE = INSTITUTION_ADDRESS_SAVE.apply { id = GeneratorUUID.v7toString() }

        val INSTITUTION_ADDRESS_NOT_EXIST = InstitutionAddress(
            InstitutionCreate.INSTITUTION_NOT_EXIST,
            AddressCreate.ADDRESS_NOT_EXIST
        )

    }

}