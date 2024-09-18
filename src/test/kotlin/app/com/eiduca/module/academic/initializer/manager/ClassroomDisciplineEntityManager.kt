package app.com.eiduca.module.academic.initializer.manager
import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

class ClassroomDisciplineEntityManager {
    companion object{
        fun initializer(testEntityManager: TestEntityManager,  model: ClassroomDiscipline): ClassroomDiscipline{

            model.classroom.course.institution.university = testEntityManager.findOrSave(model.classroom.course.institution.university)
            model.classroom.course.academicYear = testEntityManager.findOrSave(model.classroom.course.academicYear)
            model.classroom.course.institution = testEntityManager.findOrSave(model.classroom.course.institution)
            model.classroom.course = testEntityManager.findOrSave(model.classroom.course)

            model.classroom.curriculumYear = testEntityManager.findOrSave(model.classroom.curriculumYear)
            model.classroom.academicPeriod = testEntityManager.findOrSave(model.classroom.academicPeriod)
            model.classroom.dayPeriod = testEntityManager.findOrSave(model.classroom.dayPeriod)
            model.classroom = testEntityManager.findOrSave(model.classroom)

            model.profileDiscipline = testEntityManager.findOrSave(model.profileDiscipline)
            model.regimeDiscipline = testEntityManager.findOrSave(model.regimeDiscipline)
            model.discipline = testEntityManager.findOrSave(model.discipline)

            return model
        }

    }
}