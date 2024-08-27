package app.com.eiduca.module.academic.repository.concrete

import app.com.eiduca.module.academic.common.DataRangeRepository
import app.com.eiduca.module.academic.model.concrete.AcademicYear
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AcademicYearRepository: DataRangeRepository<AcademicYear> {

    @Query(name = "ModelConcrete.findByName")
    fun findByName(name: String): Optional<AcademicYear>

    @Query(name = "ModelConcrete.findByCode")
    fun findByCode(code: String): Optional<AcademicYear>

}