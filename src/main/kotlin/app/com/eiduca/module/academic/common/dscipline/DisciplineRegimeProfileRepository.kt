package app.com.eiduca.module.academic.common.dscipline

import app.com.eiduca.module.academic.model.concrete.Discipline
import app.com.eiduca.module.academic.model.concrete.ProfileDiscipline
import app.com.eiduca.module.academic.model.concrete.RegimeDiscipline
import app.com.eiduca.module.core.common.general.ConcreteRepository
import app.com.eiduca.module.core.query.EntityJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface DisciplineRegimeProfileRepository<T: DisciplineRegimeProfileModel>: ConcreteRepository<T> {
    @Query(name = EntityJPQL.FIND_ALL_DISCIPLINE)
    fun findByDiscipline(discipline: Discipline): List<T>

    @Query(name = EntityJPQL.FIND_ALL_DISCIPLINE, countName = EntityJPQL.FIND_COUNT_DISCIPLINE)
    fun findByDiscipline(discipline: Discipline, pageable: Pageable): Page<T>

    @Query(name = EntityJPQL.FIND_ALL_REGIME_DISCIPLINE)
    fun findByRegimeDiscipline(regimeDiscipline: RegimeDiscipline): List<T>

    @Query(name = EntityJPQL.FIND_ALL_REGIME_DISCIPLINE, countName = EntityJPQL.FIND_COUNT_REGIME_DISCIPLINE)
    fun findByRegimeDiscipline(regimeDiscipline: RegimeDiscipline, pageable: Pageable): Page<T>

    @Query(name = EntityJPQL.FIND_ALL_PROFILE_DISCIPLINE)
    fun findByProfileDiscipline(profileDiscipline: ProfileDiscipline): List<T>

    @Query(name = EntityJPQL.FIND_ALL_PROFILE_DISCIPLINE, countName = EntityJPQL.FIND_COUNT_PROFILE_DISCIPLINE)
    fun findByProfileDiscipline(profileDiscipline: ProfileDiscipline, pageable: Pageable): Page<T>
}