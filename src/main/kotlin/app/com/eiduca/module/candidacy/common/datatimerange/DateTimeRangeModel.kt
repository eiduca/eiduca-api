package app.com.eiduca.module.candidacy.common.datatimerange

import app.com.eiduca.module.core.common.general.ConcreteModel
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
abstract class DateTimeRangeModel(
    var startDateTime: LocalDateTime,
    var endDateTime: LocalDateTime,
): ConcreteModel() {

    constructor(): this(LocalDateTime.now(), LocalDateTime.now())

    override fun setToString(fields: String): String = super.setToString("$fields, startDateTime=$startDateTime, endDateTime=$endDateTime")
}