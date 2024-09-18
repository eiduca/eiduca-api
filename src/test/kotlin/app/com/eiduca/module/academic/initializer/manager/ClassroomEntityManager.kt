package app.com.eiduca.module.academic.initializer.manager

import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

class ClassroomEntityManager {
    companion object{
        fun initializer(testEntityManager: TestEntityManager, model: Classroom): Classroom{

            model.course.institution.university = testEntityManager.findOrSave(model.course.institution.university)
            model.course.academicYear = testEntityManager.findOrSave(model.course.academicYear)
            model.course.institution = testEntityManager.findOrSave(model.course.institution)
            model.course = testEntityManager.findOrSave(model.course)

            model.curriculumYear = testEntityManager.findOrSave(model.curriculumYear)
            model.academicPeriod = testEntityManager.findOrSave(model.academicPeriod)
            model.dayPeriod = testEntityManager.findOrSave(model.dayPeriod)

            return model
        }
    }
}