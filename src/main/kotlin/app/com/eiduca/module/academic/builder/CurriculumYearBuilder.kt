package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionBuilder
import app.com.eiduca.module.academic.model.concrete.CurriculumYear

class CurriculumYearBuilder: OrderCodeNamedDescriptionBuilder<CurriculumYear>() {
    override fun build(): CurriculumYear {
        return withDefaultValues(CurriculumYear(numb, code, name, description))
    }
}