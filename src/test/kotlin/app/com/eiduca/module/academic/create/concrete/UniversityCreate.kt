package app.com.eiduca.module.academic.create.concrete

import app.com.eiduca.module.academic.factory.UniversityFactory
import app.com.eiduca.module.academic.seed.UniversitySeed
import app.com.eiduca.module.core.util.GeneratorUUID

class UniversityCreate {

    companion object{
        val UNIVERSITY_SAVE = UniversitySeed.EIDUCA.university

        val UNIVERSITY_UPDATE = UNIVERSITY_SAVE.apply { id = GeneratorUUID.v7toString() }

        val UNIVERSITY_NOT_EXIST = UniversityFactory.build("u-eiduca-test","u-eid-t")
    }

}