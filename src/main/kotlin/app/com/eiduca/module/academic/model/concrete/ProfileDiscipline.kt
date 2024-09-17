package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionModel
import app.com.eiduca.module.academic.request.concrete.ProfileDisciplineRequest
import app.com.eiduca.module.core.interfaces.IConvertModel
import app.com.eiduca.module.core.interfaces.IConvertRequest
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_profile_disciplines")
class ProfileDiscipline(
    code: String,
    name: String,
    description: String?
): CodeNamedDescriptionModel(code, name, description), IConvertRequest<ProfileDiscipline> {
    constructor() : this("","",null)

    override fun toRequest(): ProfileDisciplineRequest = ProfileDisciplineRequest(code, name, description)

    override fun toString(): String = "ProfileDiscipline(${super.toString()})"
}