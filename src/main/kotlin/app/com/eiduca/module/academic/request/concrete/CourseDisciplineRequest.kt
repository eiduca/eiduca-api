package app.com.eiduca.module.academic.request.concrete

import app.com.eiduca.module.academic.builder.*
import app.com.eiduca.module.academic.model.concrete.CourseDiscipline
import app.com.eiduca.module.core.interfaces.IConvertModel

data class CourseDisciplineRequest(
    var course: String,
    var discipline: String,
    var regimeDiscipline: String,
    var profileDiscipline: String
): IConvertModel<CourseDiscipline> {

    override fun toModel(): CourseDiscipline = CourseDisciplineBuilder()
        .course(CourseBuilder().id(course).build())
        .discipline(DisciplineBuilder().id(discipline).build())
        .regimeDiscipline(RegimeDisciplineBuilder().id(regimeDiscipline).build())
        .profileDiscipline(ProfileDisciplineBuilder().id(profileDiscipline).build())
        .build()

}