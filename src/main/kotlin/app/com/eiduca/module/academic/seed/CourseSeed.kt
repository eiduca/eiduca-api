package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.factory.CourseFactory
import app.com.eiduca.module.academic.model.concrete.Course

enum class CourseSeed(
    val course: Course
) {
    TECHNOLOGY_EIDUCA(CourseFactory.build(
        "Course technology of eiduca",
        "technology_eiduca",
        InstitutionSeed.EIDUCA_INF.institution,
        AcademicYearSeed.YEAR_24_25.academicYear,
        ))
}