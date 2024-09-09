package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.company.CompanyRepository
import app.com.eiduca.module.academic.enums.UniversityType
import app.com.eiduca.module.academic.model.concrete.University
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UniversityRepository: CompanyRepository<University> {

    @Query(name = "ModelConcrete.findByType")
    fun findByType(type: UniversityType): List<University>

    @Query(name = "ModelConcrete.findByType", countName = "ModelConcrete.findByTypeCount")
    fun findByType(type: UniversityType, pageable: Pageable): Page<University>
}