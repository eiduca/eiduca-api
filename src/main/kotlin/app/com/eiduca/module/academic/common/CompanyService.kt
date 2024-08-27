package app.com.eiduca.module.academic.common

import app.com.eiduca.module.core.common.ConcreteService
import app.com.eiduca.module.core.exception.NotFoundException
import java.time.LocalDate

abstract class CompanyService <T: CompanyModel> (
    private val companyRepository: CompanyRepository<T>
): ConcreteService<T>(companyRepository){

    fun findByName(name: String): T = companyRepository.findByName(name).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by name") }

    fun findByAcronym(acronym: String): T = companyRepository.findByAcronym(acronym).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by acronym") }

    fun findByContact(contact: String): T = companyRepository.findByContact(contact).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by contact") }

    fun findByWebsite(website: String): T = companyRepository.findByWebsite(website).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by website") }

    fun findByFoundingDate(foundingDate: LocalDate): T = companyRepository.findByFoundingDate(foundingDate).orElseThrow { NotFoundException("Not found ${javaClass.simpleName} by founding date") }

}