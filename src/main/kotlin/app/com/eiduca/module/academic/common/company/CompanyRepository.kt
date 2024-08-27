package app.com.eiduca.module.academic.common.company

import app.com.eiduca.module.core.common.ConcreteRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.time.LocalDate
import java.util.*

@NoRepositoryBean
interface CompanyRepository <T: CompanyModel> : ConcreteRepository<T> {

    @Query(name = "ModelConcrete.findByName")
    fun findByName(name: String): Optional<T>

    @Query(name = "ModelConcrete.findByEmail")
    fun findByEmail(email: String): Optional<T>

    @Query(name = "SELECT e FROM #{#entityName} e WHERE acronym = :acronym AND deletedBy IS NULL AND deletedAt IS NULL")
    fun findByAcronym(acronym: String): Optional<T>

    @Query(name = "SELECT e FROM #{#entityName} e WHERE contact = :contact AND deletedBy IS NULL AND deletedAt IS NULL")
    fun findByContact(contact: String): Optional<T>

    @Query(name = "SELECT e FROM #{#entityName} e WHERE website = :website AND deletedBy IS NULL AND deletedAt IS NULL")
    fun findByWebsite(website: String): Optional<T>

    @Query(name = "SELECT e FROM #{#entityName} e WHERE foundingDate = :foundingDate AND deletedBy IS NULL AND deletedAt IS NULL")
    fun findByFoundingDate(foundingDate: LocalDate): Optional<T>
}