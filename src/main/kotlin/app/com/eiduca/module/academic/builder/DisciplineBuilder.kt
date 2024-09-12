package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionBuilder
import app.com.eiduca.module.academic.model.concrete.Discipline

class DisciplineBuilder: CodeNamedDescriptionBuilder<Discipline>() {
    override fun build(): Discipline {
        return withDefaultValues(Discipline(code, name, description))
    }
}