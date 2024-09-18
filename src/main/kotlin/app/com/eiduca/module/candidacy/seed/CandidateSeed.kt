package app.com.eiduca.module.candidacy.seed

import app.com.eiduca.module.academic.seed.CourseSeed
import app.com.eiduca.module.candidacy.factory.CandidateFactory
import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.module.core.seed.PersonSeed

enum class CandidateSeed(
    val candidate: Candidate
) {
    CANDIDATE_TECHNOLOGY_EIDUCA_FASE_ONE_23_24(CandidateFactory.build(
        PersonSeed.CANDIDATE.person,
        CourseSeed.TECHNOLOGY_EIDUCA.course,
        CalendarAccessExamSeed.FASE_ONE_23_24.calendarAccessExam,
        ))
}