package app.com.eiduca.module.academic.create.pivot

import app.com.eiduca.module.academic.create.concrete.InstitutionCreate
import app.com.eiduca.module.academic.create.concrete.UniversityCreate
import app.com.eiduca.module.academic.model.pivot.UniversityAddress
import app.com.eiduca.module.core.create.concrete.AddressCreate
import app.com.eiduca.module.core.util.GeneratorUUID

class UniversityAddressCreate {

    companion object{

        val UNIVERSITY_ADDRESS_SAVE = UniversityAddress(
            UniversityCreate.UNIVERSITY_UPDATE,
            AddressCreate.ADDRESS_UPDATE
        )

        val UNIVERSITY_ADDRESS_UPDATE = UNIVERSITY_ADDRESS_SAVE.apply { id = GeneratorUUID.v7toString() }

        val UNIVERSITY_ADDRESS_NOT_EXIST = UniversityAddress(
            UniversityCreate.UNIVERSITY_NOT_EXIST,
            AddressCreate.ADDRESS_NOT_EXIST
        )

    }

}