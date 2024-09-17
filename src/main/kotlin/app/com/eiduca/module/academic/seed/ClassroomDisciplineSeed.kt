package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline

enum class ClassroomDisciplineSeed(
    val classroomDiscipline: ClassroomDiscipline
) {
    TED1M_LANGUAGE_PROGRAM_ANNUAL_EVALUATION(ClassroomDiscipline(
        ClassroomSeed.TED1M.classroom,
        DisciplineSeed.LANGUAGE_PROGRAM.discipline,
        RegimeDisciplineSeed.ANNUAL.regimeDiscipline,
        ProfileDisciplineSeed.EVALUATION.profileDiscipline
    ))
}