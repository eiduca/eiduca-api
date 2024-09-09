package app.com.eiduca.module.academic.common.datarange

import app.com.eiduca.module.core.common.general.ConcreteService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.time.LocalDate

abstract class DataRangeService <T: DataRangeModel> (
    private val dataRangeRepository: DataRangeRepository<T>
): ConcreteService<T>(dataRangeRepository){

    fun findByStartDate(startDate: LocalDate): List<T> = dataRangeRepository.findByStartDate(startDate)

    fun findByStartDate(startDate: LocalDate, pageable: Pageable): Page<T> = dataRangeRepository.findByStartDate(startDate, pageable)

    fun findByEndDate(endDate: LocalDate): List<T> = dataRangeRepository.findByEndDate(endDate)

    fun findByEndDate(endDate: LocalDate, pageable: Pageable): Page<T> = dataRangeRepository.findByEndDate(endDate, pageable)
}