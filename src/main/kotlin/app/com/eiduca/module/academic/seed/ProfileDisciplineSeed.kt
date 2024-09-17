package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.factory.ProfileDisciplineFactory
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline

enum class ProfileDisciplineSeed(
    val profileDiscipline: ProfileDiscipline
) {
    METHODOLOGY(ProfileDisciplineFactory.build("Methodology", "METHODOLOGY",)),
    EVALUATION(ProfileDisciplineFactory.build("Evaluation", "EVALUATION",)),
}