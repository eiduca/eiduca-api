package app.com.eiduca.module.academic.common.datarange

import app.com.eiduca.module.core.common.ConcreteBuilder
import java.time.LocalDate

abstract  class DataRangeBuilder <T: DataRangeModel>: ConcreteBuilder<T>() {

    protected var startDate: LocalDate = LocalDate.now()
    protected var endDate: LocalDate = LocalDate.now()

    fun startDate(startDate: LocalDate) = apply{ this.startDate = startDate }

    fun endDate(endDate: LocalDate) = apply{ this.endDate = endDate }

    protected fun <T : DataRangeModel> withDefaultValues(obj: T): T {
        obj.endDate = endDate
        obj.startDate = startDate
        return  super.withDefaultValues(obj)
    }

}