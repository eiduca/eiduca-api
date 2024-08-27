package app.com.eiduca.module.academic.common

import app.com.eiduca.module.core.common.ConcreteRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.time.LocalDate
import java.util.*

@NoRepositoryBean
interface DataRangeRepository <T: DataRangeModel> : ConcreteRepository<T> {

    @Query(name = "SELECT e FROM #{#entityName} e WHERE startDate = :startDate AND deletedBy IS NULL AND deletedAt IS NULL")
    fun findByStartDate(startDate: LocalDate): Optional<T>

    @Query(name = "SELECT e FROM #{#entityName} e WHERE endDate = :endDate AND deletedBy IS NULL AND deletedAt IS NULL")
    fun findByEndDate(endDate: LocalDate): Optional<T>

}