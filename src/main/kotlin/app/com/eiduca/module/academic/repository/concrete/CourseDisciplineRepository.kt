package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.dscipline.DisciplineRegimeProfileRepository
import app.com.eiduca.module.academic.model.concrete.*
import app.com.eiduca.module.academic.query.CourseDisciplineJPQL
import app.com.eiduca.module.core.query.EntityJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CourseDisciplineRepository: DisciplineRegimeProfileRepository<CourseDiscipline>{
    @Query(name = EntityJPQL.FIND_ALL_COURSE)
    fun findByCourse(course: Course): List<CourseDiscipline>

    @Query(name = EntityJPQL.FIND_ALL_COURSE, countName = EntityJPQL.FIND_COUNT_COURSE)
    fun findByCourse(course: Course, pageable: Pageable): Page<CourseDiscipline>

    @Query(name = CourseDisciplineJPQL.FIND_BY_COURSE_AND_DISCIPLINE_AND_REGIME_DISCIPLINE_AND_PROFILE_DISCIPLINE)
    fun findByCourseAndDisciplineAndRegimeDisciplineAndProfileDiscipline(course: Course, discipline: Discipline, regimeDiscipline: RegimeDiscipline, profileDiscipline: ProfileDiscipline): Optional<CourseDiscipline>
}