package app.com.eiduca.module.academic.common

import app.com.eiduca.module.core.common.ConcreteModel
import jakarta.persistence.MappedSuperclass
import java.time.LocalDate

@MappedSuperclass
abstract class DataRangeModel(
    var startDate: LocalDate,
    var endDate: LocalDate,
):ConcreteModel() {


}