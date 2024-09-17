package app.com.eiduca.module.academic.request.concrete

import app.com.eiduca.module.academic.builder.*
import app.com.eiduca.module.academic.model.concrete.ClassroomDiscipline
import app.com.eiduca.module.core.interfaces.IConvertModel

data class ClassroomDisciplineRequest(
    var classroom: String,
    var discipline: String,
    var regimeDiscipline: String,
    var profileDiscipline: String
): IConvertModel<ClassroomDiscipline> {

    override fun toModel(): ClassroomDiscipline = ClassroomDisciplineBuilder()
        .classroom(ClassroomBuilder().id(classroom).build())
        .discipline(DisciplineBuilder().id(discipline).build())
        .regimeDiscipline(RegimeDisciplineBuilder().id(regimeDiscipline).build())
        .profileDiscipline(ProfileDisciplineBuilder().id(profileDiscipline).build())
        .build()

}