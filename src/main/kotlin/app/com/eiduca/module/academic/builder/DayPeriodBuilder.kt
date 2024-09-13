package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionBuilder
import app.com.eiduca.module.academic.model.concrete.DayPeriod

class DayPeriodBuilder: CodeNamedDescriptionBuilder<DayPeriod>() {
    override fun build(): DayPeriod {
        return withDefaultValues(DayPeriod(code, name, description))
    }
}