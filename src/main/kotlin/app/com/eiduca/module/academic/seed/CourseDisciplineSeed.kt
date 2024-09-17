package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.model.concrete.CourseDiscipline

enum class CourseDisciplineSeed(
    val courseDiscipline: CourseDiscipline
) {
    TECHNOLOGY_EIDUCA_LANGUAGE_PROGRAM_ANNUAL_EVALUATION(CourseDiscipline(
        CourseSeed.TECHNOLOGY_EIDUCA.course,
        DisciplineSeed.LANGUAGE_PROGRAM.discipline,
        RegimeDisciplineSeed.ANNUAL.regimeDiscipline,
        ProfileDisciplineSeed.EVALUATION.profileDiscipline
    ))
}