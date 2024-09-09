package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.company.CompanyBuilder
import app.com.eiduca.module.academic.enums.InstitutionType
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.model.concrete.University

class InstitutionBuilder: CompanyBuilder<Institution>() {

    private var university: University = University()

    private var type: InstitutionType = InstitutionType.FACULTY

    fun type(type: InstitutionType) = apply{ this.type = type }

    fun university(university: University) = apply{ this.university = university }

    override fun build(): Institution {
        return withDefaultValues(Institution(name, acronym, email, contact, website, foundingDate, university, type, latitude, longitude))
    }
}