package app.com.eiduca.module.academic.common.company

import app.com.eiduca.module.core.common.general.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.time.LocalDate

abstract class CompanyService <T: CompanyModel> (
    private val companyRepository: CompanyRepository<T>
): ConcreteService<T>(companyRepository){

    fun findByName(name: String): T = companyRepository.findByName(name).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by name") }

    fun findByAcronym(acronym: String): T = companyRepository.findByAcronym(acronym).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by acronym") }

    fun findByEmail(email: String): List<T> = companyRepository.findByEmail(email)
    fun findByEmail(email: String, pageable: Pageable): Page<T> = companyRepository.findByEmail(email, pageable)

    fun findByContact(contact: String): List<T> = companyRepository.findByContact(contact)
    fun findByContact(contact: String, pageable: Pageable): Page<T> = companyRepository.findByContact(contact, pageable)

    fun findByWebsite(website: String): List<T> = companyRepository.findByWebsite(website)
    fun findByWebsite(website: String, pageable: Pageable): Page<T> = companyRepository.findByWebsite(website, pageable)

    fun findByFoundingDate(foundingDate: LocalDate): List<T> = companyRepository.findByFoundingDate(foundingDate)
    fun findByFoundingDate(foundingDate: LocalDate, pageable: Pageable): Page<T> = companyRepository.findByFoundingDate(foundingDate, pageable)

    fun findByLatitude(latitude: Double?): List<T> = companyRepository.findByLatitude(latitude)
    fun findByLatitude(latitude: Double?, pageable: Pageable): Page<T> = companyRepository.findByLatitude(latitude, pageable)

    fun findByLongitude(longitude: Double?): List<T> = companyRepository.findByLongitude(longitude)
    fun findByLongitude(longitude: Double?, pageable: Pageable): Page<T> = companyRepository.findByLongitude(longitude, pageable)
}