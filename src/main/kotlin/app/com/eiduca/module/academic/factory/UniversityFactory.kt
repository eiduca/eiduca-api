package app.com.eiduca.module.academic.factory

import app.com.eiduca.module.academic.builder.UniversityBuilder
import app.com.eiduca.module.academic.enums.UniversityType
import app.com.eiduca.module.academic.model.concrete.University
import java.time.LocalDate

class UniversityFactory {
    companion object{
        fun build(name: String, acronym: String) : University = UniversityBuilder()
            .type(UniversityType.EAD)
            .website("https://eiduca.com")
            .contact("917269780")
            .acronym(acronym)
            .name(name)
            .foundingDate(LocalDate.now().minusYears(10))
            .latitude(0.0)
            .longitude(0.0)
            .build()
    }
}