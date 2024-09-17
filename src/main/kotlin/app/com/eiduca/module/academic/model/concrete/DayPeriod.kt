package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionModel
import app.com.eiduca.module.academic.request.concrete.DayPeriodRequest
import app.com.eiduca.module.core.interfaces.IConvertRequest
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name ="tb_day_periods")
class DayPeriod(
    code: String,
    name: String,
    description: String?
): CodeNamedDescriptionModel(code, name, description), IConvertRequest<DayPeriod> {

    constructor(): this("","",null)

    override fun toRequest(): DayPeriodRequest = DayPeriodRequest(code, name, description)

    override fun toString(): String = "DayPeriod(${super.toString()})"
}