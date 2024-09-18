package app.com.eiduca.module.candidacy.repository

import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.module.core.common.general.ConcreteRepository
import org.springframework.stereotype.Repository

@Repository
interface CandidateRepository: ConcreteRepository<Candidate> {
}