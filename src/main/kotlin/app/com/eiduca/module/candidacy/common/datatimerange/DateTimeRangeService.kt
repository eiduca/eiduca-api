package app.com.eiduca.module.candidacy.common.datatimerange

import app.com.eiduca.module.core.common.general.ConcreteService
import org.springframework.data.domain.Pageable
import java.time.LocalDateTime

abstract class DateTimeRangeService<T: DateTimeRangeModel> (
    private val dateTimeRangeRepository: DateTimeRangeRepository<T>
): ConcreteService<T>(dateTimeRangeRepository) {

    fun findByStartDateTime(startDateTime: LocalDateTime) = dateTimeRangeRepository.findByStartDateTime(startDateTime)

    fun findByStartDateTime(startDateTime: LocalDateTime, pageable: Pageable) = dateTimeRangeRepository.findByStartDateTime(startDateTime, pageable)

    fun findByEndDateTime(endDateTime: LocalDateTime) = dateTimeRangeRepository.findByEndDateTime(endDateTime)

    fun findByEndDateTime(endDateTime: LocalDateTime, pageable: Pageable) = dateTimeRangeRepository.findByEndDateTime(endDateTime, pageable)

}