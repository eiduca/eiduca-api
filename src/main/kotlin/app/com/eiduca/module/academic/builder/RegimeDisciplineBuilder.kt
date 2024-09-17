package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionBuilder
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline

class RegimeDisciplineBuilder: CodeNamedDescriptionBuilder<RegimeDiscipline>() {
    override fun build(): RegimeDiscipline = withDefaultValues(RegimeDiscipline(code, name, description))
}