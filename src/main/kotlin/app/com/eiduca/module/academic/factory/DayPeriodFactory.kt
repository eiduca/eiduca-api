package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.DayPeriodBuilder
import app.com.eiduca.module.academic.model.concrete.DayPeriod

class DayPeriodFactory {
    companion object{
        fun build(name: String, code: String): DayPeriod = DayPeriodBuilder()
            .name(name)
            .code(code)
            .description("DayPeriod of application")
            .build()
    }
}