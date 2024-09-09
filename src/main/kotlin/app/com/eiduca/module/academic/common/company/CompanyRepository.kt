package app.com.eiduca.module.academic.common.company

import app.com.eiduca.module.academic.query.CompanyJPQL
import app.com.eiduca.module.core.common.general.ConcreteRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.time.LocalDate
import java.util.*

@NoRepositoryBean
interface CompanyRepository <T: CompanyModel> : ConcreteRepository<T> {

    @Query(name = "ModelConcrete.findByName")
    fun findByName(name: String): Optional<T>

    @Query(name = CompanyJPQL.FIND_ALL_ACRONYM)
    fun findByAcronym(acronym: String): Optional<T>

    @Query(name = "ModelConcrete.findByEmail")
    fun findByEmail(email: String): List<T>

    @Query(name = "ModelConcrete.findByEmail", countName = "ModelConcrete.findByEmailCount")
    fun findByEmail(email: String, pageable: Pageable): Page<T>

    @Query(name = CompanyJPQL.FIND_ALL_CONTACT)
    fun findByContact(contact: String): List<T>

    @Query(name = CompanyJPQL.FIND_ALL_CONTACT, countName = CompanyJPQL.FIND_COUNT_CONTACT)
    fun findByContact(contact: String, pageable: Pageable): Page<T>

    @Query(name = CompanyJPQL.FIND_ALL_WEBSITE)
    fun findByWebsite(website: String): List<T>

    @Query(name = CompanyJPQL.FIND_ALL_WEBSITE, countName = CompanyJPQL.FIND_COUNT_WEBSITE)
    fun findByWebsite(website: String, pageable: Pageable): Page<T>

    @Query(name = CompanyJPQL.FIND_ALL_FOUNDING_DATE)
    fun findByFoundingDate(foundingDate: LocalDate): List<T>

    @Query(name = CompanyJPQL.FIND_ALL_FOUNDING_DATE, countName = CompanyJPQL.FIND_COUNT_FOUNDING_DATE)
    fun findByFoundingDate(foundingDate: LocalDate, pageable: Pageable): Page<T>

    @Query(name = "ModelConcrete.findByLatitude")
    fun findByLatitude(latitude: Double?): List<T>

    @Query(name = "ModelConcrete.findByLatitude", countName = "ModelConcrete.findByLatitudeCount")
    fun findByLatitude(latitude: Double?, pageable: Pageable): Page<T>

    @Query(name = "ModelConcrete.findByLongitude")
    fun findByLongitude(longitude: Double?): List<T>

    @Query(name = "ModelConcrete.findByLongitude", countName = "ModelConcrete.findByLongitudeCount")
    fun findByLongitude(longitude: Double?, pageable: Pageable): Page<T>
}