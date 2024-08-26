package app.com.eiduca.module.academic.model.pivot

import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.core.common.PivotModel
import app.com.eiduca.module.core.model.concrect.Address
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_institution_address")
class InstitutionAddress (
    @ManyToOne var institution: Institution,
    @ManyToOne var address: Address
): PivotModel()