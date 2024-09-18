package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.create.concrete.ClassroomDisciplineCreate
import app.com.eiduca.module.academic.initializer.manager.ClassroomDisciplineEntityManager
import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline
import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@DisplayName("Test of classroomDiscipline repository")
class ClassroomDisciplineRepositoryTest(
    @Autowired var classroomDisciplineRepository: ClassroomDisciplineRepository,
    @Autowired var testEntityManager: TestEntityManager
): ConcreteRepositoryTest<ClassroomDiscipline>(classroomDisciplineRepository, ClassroomDisciplineCreate.CLASSROOM_DISCIPLINE_SAVE) {

    @Test
    fun findByClassroom_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(classroomDisciplineRepository.findByClassroom(model.classroom))
    }

    @Test
    fun findByClassroom_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(classroomDisciplineRepository.findByClassroom(model.classroom, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByClassroomAndDisciplineAndRegimeDisciplineAndProfileDiscipline_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        classroomDisciplineRepository.findByClassroomAndDisciplineAndRegimeDisciplineAndProfileDiscipline(model.classroom, model.discipline, model.regimeDiscipline, model.profileDiscipline).ifPresentOrElse(
            { assert(it == model) },
            { throw NotFoundException("Not found classroomDiscipline by classroom, discipline, regimeDisciple, profileDiscipline") }
        )
    }

    override fun persistModel() {
        model = ClassroomDisciplineEntityManager.initializer(testEntityManager, model)
        model = testEntityManager.persistFlushFind(model)
    }
}