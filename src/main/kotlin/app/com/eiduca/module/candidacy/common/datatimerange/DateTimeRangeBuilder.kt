package app.com.eiduca.module.candidacy.common.datatimerange

import app.com.eiduca.module.core.common.general.ConcreteBuilder
import java.time.LocalDateTime

abstract class DateTimeRangeBuilder<T: DateTimeRangeModel>: ConcreteBuilder<T>() {

    protected var startDateTime: LocalDateTime = LocalDateTime.now()
    protected var endDateTime: LocalDateTime = LocalDateTime.now()

    fun startDateTime(startDateTime: LocalDateTime) = apply{ this.startDateTime = startDateTime }

    fun endDateTime(endDateTime: LocalDateTime) = apply{ this.endDateTime = endDateTime }

    protected fun <T : DateTimeRangeModel> withDefaultValues(obj: T): T {
        obj.endDateTime = endDateTime
        obj.startDateTime = startDateTime
        return  super.withDefaultValues(obj)
    }
}