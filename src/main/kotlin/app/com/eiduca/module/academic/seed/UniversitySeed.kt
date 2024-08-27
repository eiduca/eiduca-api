package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.factory.UniversityFactory
import app.com.eiduca.module.academic.model.concrete.University

enum class UniversitySeed(val university: University) {
    EIDUCA(UniversityFactory.build("eiduca", "eid"))
}