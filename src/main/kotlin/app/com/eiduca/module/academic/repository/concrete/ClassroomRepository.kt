package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.model.concrete.*
import app.com.eiduca.module.academic.query.ClassroomJPQL
import app.com.eiduca.module.core.common.general.ConcreteRepository
import app.com.eiduca.module.core.query.EntityJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ClassroomRepository: ConcreteRepository<Classroom> {
    @Query(name = "ModelConcrete.findByCode")
    fun findByCode(code: String): Optional<Classroom>

    @Query(name = EntityJPQL.FIND_ALL_COURSE)
    fun findByCourse(course: Course): List<Classroom>

    @Query(name = EntityJPQL.FIND_ALL_COURSE, countName = EntityJPQL.FIND_COUNT_COURSE)
    fun findByCourse(course: Course, pageable: Pageable): Page<Classroom>

    @Query(name = EntityJPQL.FIND_ALL_DAY_PERIOD)
    fun findByDayPeriod(dayPeriod: DayPeriod): List<Classroom>

    @Query(name = EntityJPQL.FIND_ALL_DAY_PERIOD, countName = EntityJPQL.FIND_COUNT_DAY_PERIOD)
    fun findByDayPeriod(dayPeriod: DayPeriod, pageable: Pageable): Page<Classroom>

    @Query(name = EntityJPQL.FIND_ALL_ACADEMIC_PERIOD)
    fun findByAcademicPeriod(academicPeriod: AcademicPeriod): List<Classroom>

    @Query(name = EntityJPQL.FIND_ALL_ACADEMIC_PERIOD, countName = EntityJPQL.FIND_COUNT_ACADEMIC_PERIOD)
    fun findByAcademicPeriod(academicPeriod: AcademicPeriod, pageable: Pageable): Page<Classroom>

    @Query(name = EntityJPQL.FIND_ALL_CURRICULUM_YEAR)
    fun findByCurriculumYear(curriculumYear: CurriculumYear): List<Classroom>

    @Query(name = EntityJPQL.FIND_ALL_CURRICULUM_YEAR, countName = EntityJPQL.FIND_COUNT_CURRICULUM_YEAR)
    fun findByCurriculumYear(curriculumYear: CurriculumYear, pageable: Pageable): Page<Classroom>

    @Query(name = ClassroomJPQL.FIND_BY_COURSE_AND_DAY_PERIOD_AND_ACADEMIC_PERIOD_AND_CURRICULUM_YEAR)
    fun findByCourseAndDayPeriodAndAcademicPeriodAndCurriculumYear(course: Course, dayPeriod: DayPeriod, academicPeriod: AcademicPeriod, curriculumYear: CurriculumYear): Optional<Classroom>
}