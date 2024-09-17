package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionBuilder
import app.com.eiduca.module.academic.model.concrete.AcademicPeriod

class AcademicPeriodBuilder: OrderCodeNamedDescriptionBuilder<AcademicPeriod>() {
    override fun build(): AcademicPeriod {
        return withDefaultValues(AcademicPeriod(numb, code, name, description))
    }
}