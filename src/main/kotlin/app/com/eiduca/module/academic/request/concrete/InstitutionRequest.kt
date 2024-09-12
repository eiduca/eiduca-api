package app.com.eiduca.module.academic.request.concrete

import app.com.eiduca.module.academic.builder.InstitutionBuilder
import app.com.eiduca.module.academic.builder.UniversityBuilder
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.core.interfaces.IConvertModel
import java.time.LocalDate

data class InstitutionRequest(
    val university: String,
    val name: String,
    val acronym: String,
    val email: String,
    val contact: String,
    val website: String,
    val foundingDate: LocalDate,
    val latitude: Double? = null,
    val longitude: Double? = null,
): IConvertModel<Institution>{

    override fun toModel() : Institution = InstitutionBuilder()
        .university(UniversityBuilder().id(university).build())
        .name(name)
        .acronym(acronym)
        .email(email)
        .contact(contact)
        .website(website)
        .foundingDate(foundingDate)
        .build()

}