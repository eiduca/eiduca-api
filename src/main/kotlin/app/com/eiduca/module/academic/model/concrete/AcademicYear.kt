package app.com.eiduca.module.academic.model.concrete

import app.com.eiduca.module.academic.common.DataRangeModel
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name ="tb_academic_year")
class AcademicYear(
    @Column(unique = true) var name: String,
    @Column(unique = true) var code: String,
    startDate: LocalDate,
    endDate: LocalDate,
): DataRangeModel(startDate, endDate) {
}