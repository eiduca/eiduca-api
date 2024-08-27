package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.company.CompanyRepository
import app.com.eiduca.module.academic.enums.InstitutionType
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.model.concrete.University
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface InstitutionRepository: CompanyRepository<Institution> {

    @Query(name = "ModelConcrete.findByType")
    fun findByType(type: InstitutionType): Optional<Institution>

    @Query(name = "SELECT i FROM Institution i WHERE university = :university AND deletedBy IS NULL AND deletedAt IS NULL")
    fun findByUniversity(university: University): Optional<Institution>
}