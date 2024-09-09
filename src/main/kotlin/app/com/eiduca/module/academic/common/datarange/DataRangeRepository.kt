package app.com.eiduca.module.academic.common.datarange

import app.com.eiduca.module.academic.query.DataRangeJPQL
import app.com.eiduca.module.core.common.general.ConcreteRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.time.LocalDate

@NoRepositoryBean
interface DataRangeRepository <T: DataRangeModel> : ConcreteRepository<T> {

    @Query(name = DataRangeJPQL.FIND_ALL_START_DATE)
    fun findByStartDate(startDate: LocalDate): List<T>

    @Query(name = DataRangeJPQL.FIND_ALL_START_DATE, countName = DataRangeJPQL.FIND_COUNT_START_DATE)
    fun findByStartDate(startDate: LocalDate, pageable: Pageable): Page<T>

    @Query(name = DataRangeJPQL.FIND_ALL_END_DATE)
    fun findByEndDate(endDate: LocalDate): List<T>

    @Query(name = DataRangeJPQL.FIND_ALL_END_DATE, countName = DataRangeJPQL.FIND_COUNT_END_DATE)
    fun findByEndDate(endDate: LocalDate, pageable: Pageable): Page<T>

}