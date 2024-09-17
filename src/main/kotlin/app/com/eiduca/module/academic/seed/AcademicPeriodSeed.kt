package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.factory.AcademicPeriodFactory
import app.com.eiduca.module.academic.model.concrete.AcademicPeriod

enum class AcademicPeriodSeed(
    val academicPeriod: AcademicPeriod
) {
    FIRST_SEMESTER(AcademicPeriodFactory.build(1,"First semester", "FIRST_SEMESTER")),
    SECOND_SEMESTER(AcademicPeriodFactory.build(2,"Second semester", "SECOND_SEMESTER")),
}