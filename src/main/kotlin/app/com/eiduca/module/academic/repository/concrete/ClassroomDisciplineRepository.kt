package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.dscipline.DisciplineRegimeProfileRepository
import app.com.eiduca.module.academic.model.concrete.*
import app.com.eiduca.module.academic.query.ClassroomDisciplineJPQL
import app.com.eiduca.module.core.query.EntityJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ClassroomDisciplineRepository: DisciplineRegimeProfileRepository<ClassroomDiscipline>{
    @Query(name = EntityJPQL.FIND_ALL_CLASSROOM)
    fun findByClassroom(classroom: Classroom): List<ClassroomDiscipline>

    @Query(name = EntityJPQL.FIND_ALL_CLASSROOM, countName = EntityJPQL.FIND_COUNT_CLASSROOM)
    fun findByClassroom(classroom: Classroom, pageable: Pageable): Page<ClassroomDiscipline>

    @Query(name = ClassroomDisciplineJPQL.FIND_BY_CLASSROOM_AND_DISCIPLINE_AND_REGIME_DISCIPLINE_AND_PROFILE_DISCIPLINE)
    fun findByClassroomAndDisciplineAndRegimeDisciplineAndProfileDiscipline(classroom: Classroom, discipline: Discipline, regimeDiscipline: RegimeDiscipline, profileDiscipline: ProfileDiscipline): Optional<ClassroomDiscipline>
}