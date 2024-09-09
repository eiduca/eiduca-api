package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.InstitutionBuilder
import app.com.eiduca.module.academic.enums.InstitutionType
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.seed.UniversitySeed
import java.time.LocalDate

class InstitutionFactory {

    companion object{

        fun build(name: String, acronym: String) : Institution = InstitutionBuilder()
            .university(UniversitySeed.EIDUCA.university)
            .type(InstitutionType.FACULTY)
            .website("https://eiduca.dir.com")
            .contact("918269780")
            .acronym(acronym)
            .name(name)
            .foundingDate(LocalDate.now().minusYears(10))
            .latitude(0.0)
            .longitude(0.0)
            .build()

    }

}