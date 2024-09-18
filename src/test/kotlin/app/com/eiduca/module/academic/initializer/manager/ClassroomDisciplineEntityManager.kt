package app.com.eiduca.module.academic.initializer.manager
import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline
import app.com.eiduca.util.EntityManagerUtils.findOrSave
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

class ClassroomDisciplineEntityManager {
    companion object{
        fun initializer(testEntityManager: TestEntityManager,  model: ClassroomDiscipline): ClassroomDiscipline{
            model.classroom = testEntityManager.findOrSave(
                ClassroomEntityManager.initializer(testEntityManager, model.classroom)
            )

            model.profileDiscipline = testEntityManager.findOrSave(model.profileDiscipline)
            model.regimeDiscipline = testEntityManager.findOrSave(model.regimeDiscipline)
            model.discipline = testEntityManager.findOrSave(model.discipline)

            return model
        }

    }
}