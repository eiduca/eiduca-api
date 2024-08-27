package app.com.eiduca.module.academic.builder

import app.com.eiduca.module.academic.common.company.CompanyBuilder
import app.com.eiduca.module.academic.enums.UniversityType
import app.com.eiduca.module.academic.model.concrete.University

class UniversityBuilder: CompanyBuilder<University>() {

    private var type: UniversityType = UniversityType.INDEFINITE

    fun type(type: UniversityType) = apply{ this.type = type }

    override fun build(): University {
        val university = University(name, acronym, email, contact, website, foundingDate, type)
        return withDefaultValues(university)
    }

}