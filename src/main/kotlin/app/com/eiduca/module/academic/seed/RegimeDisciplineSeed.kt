package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.factory.RegimeDisciplineFactory
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline

enum class RegimeDisciplineSeed(
    val regimeDiscipline: RegimeDiscipline
) {
    SEMIANNUAL(RegimeDisciplineFactory.build("Semiannual", "SEMIANNUAL",)),
    MODULAR(RegimeDisciplineFactory.build("Modular", "MODULAR",)),
    ANNUAL(RegimeDisciplineFactory.build("Annual", "ANNUAL",))
}