package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionBuilder
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline

class ProfileDisciplineBuilder: CodeNamedDescriptionBuilder<ProfileDiscipline>() {
    override fun build(): ProfileDiscipline = withDefaultValues(ProfileDiscipline(code, name, description))
}