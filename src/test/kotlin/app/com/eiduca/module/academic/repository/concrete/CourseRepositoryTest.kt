package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionRepositoryTest
import app.com.eiduca.module.academic.create.concrete.CourseCreate
import app.com.eiduca.module.academic.model.concrete.Course
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import app.com.eiduca.util.EntityManagerUtils.findOrSave

@DataJpaTest
@DisplayName("Test of course repository")
class CourseRepositoryTest(
    @Autowired var courseRepository: CourseRepository,
    @Autowired var testEntityManager: TestEntityManager
): CodeNamedDescriptionRepositoryTest<Course>(courseRepository, CourseCreate.COURSE_SAVE) {

    @Test
    @DisplayName("Find model course by name institution successful, return list")
    fun findByInstitution_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(courseRepository.findByInstitution(model.institution))
    }

    @Test
    @DisplayName("Find model course by name institution successful, return list pageable")
    fun findByInstitution_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(courseRepository.findByInstitution(model.institution, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find model course by name institution successful, return list")
    fun findByAcademicYear_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(courseRepository.findByAcademicYear(model.academicYear))
    }

    @Test
    @DisplayName("Find model course by name institution successful, return list pageable")
    fun findByAcademicYear_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(courseRepository.findByAcademicYear(model.academicYear, AssertUtil.PAGEABLE))
    }

    override fun persistModel() {
        model.institution.university = testEntityManager.findOrSave(model.institution.university)
        model.academicYear = testEntityManager.findOrSave(model.academicYear)
        model.institution = testEntityManager.findOrSave(model.institution)
        model = testEntityManager.persistFlushFind(model)
    }
}

