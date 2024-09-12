package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.factory.DisciplineFactory
import app.com.eiduca.module.academic.model.concrete.Discipline

enum class DisciplineSeed(
    val discipline: Discipline
) {
    LANGUAGE_PROGRAM(DisciplineFactory.build("Language program", "language_program",))
}