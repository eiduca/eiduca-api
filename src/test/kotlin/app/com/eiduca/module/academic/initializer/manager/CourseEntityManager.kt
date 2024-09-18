package app.com.eiduca.module.academic.initializer.manager

import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

class CourseEntityManager {
    companion object{
        fun initializer(testEntityManager: TestEntityManager, model: Course): Course {
            model.institution.university = testEntityManager.findOrSave(model.institution.university)
            model.institution = testEntityManager.findOrSave(model.institution)
            model.academicYear = testEntityManager.findOrSave(model.academicYear)
            return model
        }
    }
}