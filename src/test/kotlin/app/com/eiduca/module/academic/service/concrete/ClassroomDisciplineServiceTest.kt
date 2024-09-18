package app.com.eiduca.module.academic.service.concrete

import app.com.eiduca.module.academic.common.dscipline.DisciplineRegimeProfileServiceTest
import app.com.eiduca.module.academic.create.concrete.ClassroomDisciplineCreate
import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline
import app.com.eiduca.module.academic.repository.concrete.ClassroomDisciplineRepository
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageImpl

@DataJpaTest
@DisplayName("Test of classroomDiscipline service")
class ClassroomDisciplineServiceTest: DisciplineRegimeProfileServiceTest<ClassroomDiscipline>() {
    @InjectMocks
    lateinit var classroomDisciplineService: ClassroomDisciplineService
    @Mock
    lateinit var classroomDisciplineRepository: ClassroomDisciplineRepository

    @BeforeEach
    fun setUp(){
        setUpDisciplineRegimeProfile(classroomDisciplineService, classroomDisciplineRepository, ClassroomDisciplineCreate.CLASSROOM_DISCIPLINE_SAVE)

        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(classroomDisciplineRepository.findByClassroom(model.classroom)).thenReturn(list)
        BDDMockito.`when`(classroomDisciplineRepository.findByClassroom(model.classroom, AssertUtil.PAGEABLE)).thenReturn(page)
    }

    @Test
    fun findByClassroom_ReturnList_WhenSuccessful() {
        AssertUtil.assert(classroomDisciplineService.findByClassroom(model.classroom))
    }

    @Test
    fun findByClassroom_ReturnPage_WhenSuccessful() {
        AssertUtil.assert(classroomDisciplineService.findByClassroom(model.classroom, AssertUtil.PAGEABLE))
    }
}