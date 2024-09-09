package app.com.eiduca.module.academic.create.concrete

import app.com.eiduca.module.academic.factory.InstitutionFactory
import app.com.eiduca.module.academic.seed.InstitutionSeed
import app.com.eiduca.module.core.util.GeneratorUUID

class InstitutionCreate {

    companion object{
        val INSTITUTION_SAVE = InstitutionSeed.EIDUCA_INF.institution

        val INSTITUTION_UPDATE = INSTITUTION_SAVE.apply { id = GeneratorUUID.v7toString() }

        val INSTITUTION_NOT_EXIST = InstitutionFactory.build("eiduca-test","eid-t")
    }

}