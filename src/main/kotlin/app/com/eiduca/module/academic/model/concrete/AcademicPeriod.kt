package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionModel
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name ="tb_academic_period")
class AcademicPeriod (
    code: String,
    name: String,
    description: String?
): CodeNamedDescriptionModel(code, name, description) {

    constructor(): this("","",null)

}