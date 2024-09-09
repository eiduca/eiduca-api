package app.com.eiduca.module.academic.request

import app.com.eiduca.module.academic.builder.UniversityBuilder
import app.com.eiduca.module.academic.enums.UniversityType
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.core.interfaces.IConvertModel
import java.time.LocalDate

data class UniversityRequest(
    val name: String,
    val acronym: String,
    val email: String,
    val contact: String,
    val website: String,
    val foundingDate: LocalDate,
    val type: UniversityType = UniversityType.INDEFINITE
): IConvertModel<University>{

    override fun toModel() : University = UniversityBuilder()
        .type(type)
        .name(name)
        .acronym(acronym)
        .email(email)
        .contact(contact)
        .website(website)
        .foundingDate(foundingDate)
        .build()

}