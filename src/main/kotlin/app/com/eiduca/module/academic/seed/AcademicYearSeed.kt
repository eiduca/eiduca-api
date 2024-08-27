package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.factory.AcademicYearFactory
import app.com.eiduca.module.academic.model.concrete.AcademicYear

enum class AcademicYearSeed(val academicYear: AcademicYear) {
    YEAR_23_24(AcademicYearFactory.build("23/24")),
    YEAR_24_25(AcademicYearFactory.build("24/25"))
}