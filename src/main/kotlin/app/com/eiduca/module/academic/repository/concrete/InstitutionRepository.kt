package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.company.CompanyRepository
import app.com.eiduca.module.academic.enums.InstitutionType
import app.com.eiduca.module.academic.model.concrete.Institution
import app.com.eiduca.module.academic.model.concrete.University
import app.com.eiduca.module.academic.query.InstitutionJPQL
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface InstitutionRepository: CompanyRepository<Institution> {

    @Query(name = "ModelConcrete.findByType")
    fun findByType(type: InstitutionType): List<Institution>

    @Query(name = "ModelConcrete.findByType", countName = "ModelConcrete.findByTypeCount")
    fun findByType(type: InstitutionType, pageable: Pageable): Page<Institution>

    @Query(name = InstitutionJPQL.FIND_ALL_UNIVERSITY)
    fun findByUniversity(university: University): List<Institution>

    @Query(name = InstitutionJPQL.FIND_ALL_UNIVERSITY, countName = InstitutionJPQL.FIND_COUNT_UNIVERSITY)
    fun findByUniversity(university: University, pageable: Pageable): Page<Institution>

    @Query(name = InstitutionJPQL.FIND_ONE_NAME_UNIVERSITY)
    fun findByNameAndUniversity(name: String, university: University): Optional<Institution>
}