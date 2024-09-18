package app.com.eiduca.module.candidacy.common.datatimerange

import app.com.eiduca.module.candidacy.query.DateTimeRangeJPQL
import app.com.eiduca.module.core.common.general.ConcreteRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.time.LocalDateTime

@NoRepositoryBean
interface DateTimeRangeRepository<T: DateTimeRangeModel>: ConcreteRepository<T> {

    @Query(name = DateTimeRangeJPQL.FIND_ALL_START_DATETIME)
    fun findByStartDateTime(startDateTime: LocalDateTime): List<T>

    @Query(name = DateTimeRangeJPQL.FIND_ALL_START_DATETIME, countName = DateTimeRangeJPQL.FIND_COUNT_START_DATETIME)
    fun findByStartDateTime(startDateTime: LocalDateTime, pageable: Pageable): Page<T>

    @Query(name = DateTimeRangeJPQL.FIND_ALL_END_DATETIME)
    fun findByEndDateTime(endDateTime: LocalDateTime): List<T>

    @Query(name = DateTimeRangeJPQL.FIND_ALL_END_DATETIME, countName = DateTimeRangeJPQL.FIND_COUNT_END_DATETIME)
    fun findByEndDateTime(endDateTime: LocalDateTime, pageable: Pageable): Page<T>

}