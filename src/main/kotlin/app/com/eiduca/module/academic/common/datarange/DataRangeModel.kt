package app.com.eiduca.module.academic.common.datarange

import app.com.eiduca.module.core.common.general.ConcreteModel
import jakarta.persistence.MappedSuperclass
import java.time.LocalDate

@MappedSuperclass
abstract class DataRangeModel(
    var startDate: LocalDate,
    var endDate: LocalDate,
): ConcreteModel() {

    constructor(): this(LocalDate.now(), LocalDate.now())

    override fun setToString(fields: String): String = super.setToString("startDate=$startDate, endDate=$endDate, $fields")
}