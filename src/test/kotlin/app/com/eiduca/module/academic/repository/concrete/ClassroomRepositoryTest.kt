package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.create.concrete.ClassroomCreate
import app.com.eiduca.module.academic.initializer.manager.ClassroomEntityManager
import app.com.eiduca.module.academic.model.concrete.Classroom
import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import app.com.eiduca.util.EntityManagerUtils.findOrSave

@DataJpaTest
@DisplayName("Test of classroom repository")
class ClassroomRepositoryTest(
    @Autowired var classroomRepository: ClassroomRepository,
    @Autowired var testEntityManager: TestEntityManager
): ConcreteRepositoryTest<Classroom>(classroomRepository, ClassroomCreate.CLASSROOM_SAVE) {

    @Test
    fun findByCode_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        classroomRepository.findByCode(model.code).ifPresentOrElse(
            { assert(it == model) },
            { throw NotFoundException("Not found Classroom by code") }
        )
    }

    @Test
    fun findByCourse_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(classroomRepository.findByCourse(model.course))
    }

    @Test
    fun findByCourse_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(classroomRepository.findByCourse(model.course, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByDayPeriod_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(classroomRepository.findByDayPeriod(model.dayPeriod))
    }

    @Test
    fun findByDayPeriod_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(classroomRepository.findByDayPeriod(model.dayPeriod, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByAcademicPeriod_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(classroomRepository.findByAcademicPeriod(model.academicPeriod))
    }

    @Test
    fun findByAcademicPeriod_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(classroomRepository.findByAcademicPeriod(model.academicPeriod, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCurriculumYear_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(classroomRepository.findByCurriculumYear(model.curriculumYear))
    }

    @Test
    fun findByCurriculumYear_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(classroomRepository.findByCurriculumYear(model.curriculumYear, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear_WhenSuccessful() {
        runner()
        persistModel()
        classroomRepository.findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear(model.course, model.dayPeriod, model.academicPeriod, model.curriculumYear).ifPresentOrElse(
            { assert(it == model) },
            { throw NotFoundException("Not found Classroom by course, dayPeriod, academicPeriod, curriculumYear") }
        )
    }

    override fun persistModel() {
        model = testEntityManager.persistFlushFind(ClassroomEntityManager.initializer(testEntityManager, model))
    }
}