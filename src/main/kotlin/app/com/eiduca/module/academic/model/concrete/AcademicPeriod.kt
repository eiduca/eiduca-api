package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionModel
import app.com.eiduca.module.academic.request.concrete.AcademicPeriodRequest
import app.com.eiduca.module.core.interfaces.IConvertRequest

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name ="tb_academic_periods")
class AcademicPeriod (
    numb: Int,
    code: String,
    name: String,
    description: String?
): OrderCodeNamedDescriptionModel(numb, code, name, description), IConvertRequest<AcademicPeriod> {
    constructor() : this(0, "","","")

    override fun toString(): String = "AcademicPeriod(${super.toString()})"

    override fun toRequest(): AcademicPeriodRequest = AcademicPeriodRequest(numb, code, name, description)
}