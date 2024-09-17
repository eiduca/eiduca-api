package app.com.eiduca.module.academic.seed

import app.com.eiduca.module.academic.factory.ClassroomFactory
import app.com.eiduca.module.academic.model.concrete.Classroom

enum class ClassroomSeed(
    var classroom: Classroom
) {
    TED1M(ClassroomFactory.build("TED1M1", CourseSeed.TECHNOLOGY_EIDUCA.course, DayPeriodSeed.MORNING.dayPeriod, AcademicPeriodSeed.FIRST_SEMESTER.academicPeriod, CurriculumYearSeed.FIRST_YEAR.curriculumYear)),
    TED1T(ClassroomFactory.build("TED1T2", CourseSeed.TECHNOLOGY_EIDUCA.course, DayPeriodSeed.AFTERNOON.dayPeriod, AcademicPeriodSeed.SECOND_SEMESTER.academicPeriod ,CurriculumYearSeed.FIRST_YEAR.curriculumYear))
}