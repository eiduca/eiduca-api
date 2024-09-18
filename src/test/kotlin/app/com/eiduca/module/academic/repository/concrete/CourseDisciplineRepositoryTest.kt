package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.create.concrete.CourseDisciplineCreate
import app.com.eiduca.module.academic.initializer.manager.CourseDisciplineEntityManager
import app.com.eiduca.module.academic.model.concrete.CourseDiscipline
import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@DisplayName("Test of courseDiscipline repository")
class CourseDisciplineRepositoryTest(
    @Autowired var courseDisciplineRepository: CourseDisciplineRepository,
    @Autowired var testEntityManager: TestEntityManager
): ConcreteRepositoryTest<CourseDiscipline>(courseDisciplineRepository, CourseDisciplineCreate.COURSE_DISCIPLINE_SAVE) {

    @Test
    fun findByCourse_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(courseDisciplineRepository.findByCourse(model.course))
    }

    @Test
    fun findByCourse_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(courseDisciplineRepository.findByCourse(model.course, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCourseAndDisciplineAndRegimeDisciplineAndProfileDiscipline_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        courseDisciplineRepository.findByCourseAndDisciplineAndRegimeDisciplineAndProfileDiscipline(model.course, model.discipline, model.regimeDiscipline, model.profileDiscipline).ifPresentOrElse(
            { assert(it == model) },
            { throw NotFoundException("Not found classroomDiscipline by course, discipline, regimeDisciple, profileDiscipline") }
        )
    }

    override fun persistModel() {
        model = CourseDisciplineEntityManager.initializer(testEntityManager, model)
        model = testEntityManager.persistFlushFind(model)
    }
}

