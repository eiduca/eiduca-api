package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.factory.CurriculumYearFactory
import app.com.eiduca.module.academic.model.concrete.CurriculumYear

enum class CurriculumYearSeed(
    val curriculumYear: CurriculumYear
) {
    FIRST_YEAR(CurriculumYearFactory.build(1,"First year", "FIRST_YEAR")),
    SECOND_YEAR(CurriculumYearFactory.build(2,"Second year", "SECOND_YEAR")),
    THIRD_YEAR(CurriculumYearFactory.build(3,"Third year", "THIRD_YEAR")),
    FOURTH_YEAR(CurriculumYearFactory.build(4,"Fourth year", "FOURTH_YEAR")),
    FIFTH_YEAR(CurriculumYearFactory.build(5,"Fifth year", "FIFTH_YEAR")),
    SIXTH_YEAR(CurriculumYearFactory.build(6,"Sixth year", "SIXTH_YEAR")),
}