package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.AcademicYearBuilder
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import java.time.LocalDate

class AcademicYearFactory {
    companion object{
        fun build(name: String) : AcademicYear = AcademicYearBuilder()
            .name(name)
            .code("code_$name")
            .startDate(LocalDate.now())
            .endDate(LocalDate.now().plusYears(1))
            .build()

    }
}