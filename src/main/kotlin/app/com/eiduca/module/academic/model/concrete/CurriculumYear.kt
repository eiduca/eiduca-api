package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.order.OrderCodeNamedDescriptionModel
import app.com.eiduca.module.academic.request.concrete.CurriculumYearRequest
import app.com.eiduca.module.core.interfaces.IConvertRequest
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_curriculum_years")
class CurriculumYear(
    numb: Int,
    code: String,
    name: String,
    description: String?,
): OrderCodeNamedDescriptionModel(numb, code, name, description), IConvertRequest<CurriculumYear> {

    constructor(): this(0,"","",null)

    override fun toString(): String = "CurriculumYear(${super.toString()})"

    override fun toRequest(): CurriculumYearRequest = CurriculumYearRequest(numb, code, name, description)
}