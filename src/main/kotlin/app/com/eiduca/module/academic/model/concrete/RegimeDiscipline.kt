package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionModel
import app.com.eiduca.module.academic.request.concrete.RegimeDisciplineRequest
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.interfaces.IConvertRequest
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_regime_disciplines")
class RegimeDiscipline(
    code: String,
    name: String,
    description: String?
): CodeNamedDescriptionModel(code, name, description), IConvertRequest<RegimeDiscipline> {
    constructor() : this("","",null)

    override fun toRequest(): RegimeDisciplineRequest = RegimeDisciplineRequest(code, name, description)

    override fun toString(): String = "RegimeDiscipline(${super.toString()})"
}