package app.com.eiduca.module.academic.model.pivot

import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.core.common.PivotModel
import app.com.eiduca.module.core.model.concrect.Address
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_university_address")
class UniversityAddress (
    @ManyToOne var university: University,
    @ManyToOne var address: Address
): PivotModel()