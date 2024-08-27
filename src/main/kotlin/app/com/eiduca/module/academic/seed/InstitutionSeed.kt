package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.factory.InstitutionFactory
import app.com.eiduca.module.academic.model.concrete.Institution

enum class InstitutionSeed(val institution: Institution) {
    EIDUCA_INF(InstitutionFactory.build("eiduca-inf", "eid-inf")),
    EIDUCA_DIR(InstitutionFactory.build("eiduca-dir", "eid-dir"))
}