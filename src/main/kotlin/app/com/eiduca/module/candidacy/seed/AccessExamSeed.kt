package app.com.eiduca.module.candidacy.seed

import app.com.eiduca.module.academic.seed.CourseSeed
import app.com.eiduca.module.academic.seed.DisciplineSeed
import app.com.eiduca.module.candidacy.factory.AccessExamFactory
import app.com.eiduca.module.candidacy.model.AccessExam

enum class AccessExamSeed(
    val accessExam: AccessExam
) {
    TECHNOLOGY_EIDUCA_LANGUAGE_PROGRAM_FASE_ONE_23_24(AccessExamFactory.build(
        CourseSeed.TECHNOLOGY_EIDUCA.course,
        DisciplineSeed.LANGUAGE_PROGRAM.discipline,
        CalendarAccessExamSeed.FASE_ONE_23_24.calendarAccessExam
    ))
}