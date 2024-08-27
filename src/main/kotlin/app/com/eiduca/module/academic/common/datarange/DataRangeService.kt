package app.com.eiduca.module.academic.common.datarange

import app.com.eiduca.module.core.common.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import java.time.LocalDate

abstract class DataRangeService <T: DataRangeModel> (
    private val dataRangeRepository: DataRangeRepository<T>
): ConcreteService<T>(dataRangeRepository){

    fun findByStartDate(startDate: LocalDate): T = dataRangeRepository.findByStartDate(startDate).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by start date") }

    fun findByEndDate(endDate: LocalDate): T = dataRangeRepository.findByEndDate(endDate).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by end date") }

}