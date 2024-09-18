package app.com.eiduca.module.academic.initializer.manager

import app.com.eiduca.module.academic.model.concrete.CourseDiscipline
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

class CourseDisciplineEntityManager {
    companion object{
        fun initializer(testEntityManager: TestEntityManager,  model: CourseDiscipline): CourseDiscipline{

            model.course.institution.university = testEntityManager.findOrSave(model.course.institution.university)
            model.course.academicYear = testEntityManager.findOrSave(model.course.academicYear)
            model.course.institution = testEntityManager.findOrSave(model.course.institution)
            model.course = testEntityManager.findOrSave(model.course)

            model.profileDiscipline = testEntityManager.findOrSave(model.profileDiscipline)
            model.regimeDiscipline = testEntityManager.findOrSave(model.regimeDiscipline)
            model.discipline = testEntityManager.findOrSave(model.discipline)

            return model
        }

    }
}