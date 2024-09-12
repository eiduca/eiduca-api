package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionModel
import app.com.eiduca.module.academic.request.concrete.DisciplineRequest
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name ="tb_disciplines")
class Discipline(
    code: String,
    name: String,
    description: String?
): CodeNamedDescriptionModel(code, name, description){

    constructor(): this("","",null)

    fun toDisciplineRequest(): DisciplineRequest = DisciplineRequest(code, name, description)
}