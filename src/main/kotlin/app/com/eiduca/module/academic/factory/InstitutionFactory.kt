package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.InstitutionBuilder
import app.com.eiduca.module.academic.enums.InstitutionType
import app.com.eiduca.module.academic.model.concrete.Institution
import java.time.LocalDate

class InstitutionFactory {

    companion object{

        fun build(name: String, acronym: String) : Institution = InstitutionBuilder()
            .type(InstitutionType.FACULTY)
            .website("https://eiduca.dir.com")
            .contact("918269780")
            .acronym(acronym)
            .name(name)
            .foundingDate(LocalDate.now().minusYears(10))
            .build()

    }

}