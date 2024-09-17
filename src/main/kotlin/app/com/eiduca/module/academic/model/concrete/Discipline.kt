package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionModel
import app.com.eiduca.module.academic.request.concrete.DisciplineRequest
import app.com.eiduca.module.core.interfaces.IConvertRequest
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name ="tb_disciplines")
class Discipline(
    code: String,
    name: String,
    description: String?
): CodeNamedDescriptionModel(code, name, description), IConvertRequest<Discipline> {

    constructor(): this("","",null)

    override fun toRequest(): DisciplineRequest = DisciplineRequest(code, name, description)

    override fun toString(): String = "Discipline(${super.toString()})"
}