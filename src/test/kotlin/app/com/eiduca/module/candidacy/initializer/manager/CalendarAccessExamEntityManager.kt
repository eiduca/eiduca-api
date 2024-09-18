package app.com.eiduca.module.candidacy.initializer.manager

import app.com.eiduca.module.candidacy.model.CalendarAccessExam
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

class CalendarAccessExamEntityManager {
    companion object{
        fun initializer(testEntityManager: TestEntityManager, model: CalendarAccessExam): CalendarAccessExam{
            model.academicYear = testEntityManager.findOrSave(model.academicYear)
            return model
        }
    }
}