package app.com.eiduca.module.candidacy.initializer.manager

import app.com.eiduca.module.academic.initializer.manager.CourseEntityManager
import app.com.eiduca.module.candidacy.model.Candidate
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

class CandidateEntityManager {
    companion object{
        fun initializer(testEntityManager: TestEntityManager, model: Candidate): Candidate{
            model.calendarAccessExam.academicYear = testEntityManager.findOrSave(model.calendarAccessExam.academicYear)
            model.calendarAccessExam = testEntityManager.findOrSave(model.calendarAccessExam)
            model.course = testEntityManager.findOrSave(
                CourseEntityManager.initializer(testEntityManager, model.course)
            )
            model.person = testEntityManager.findOrSave(model.person)
            return model
        }
    }
}