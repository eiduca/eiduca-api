package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.factory.DayPeriodFactory
import app.com.eiduca.module.academic.model.concrete.DayPeriod

enum class DayPeriodSeed(
    val dayPeriod: DayPeriod
) {
    MORNING(DayPeriodFactory.build("Morning", "MORNING")),
    AFTERNOON(DayPeriodFactory.build("Afternoon", "AFTERNOON")),
    NIGHT(DayPeriodFactory.build("Night", "NIGHT")),
}