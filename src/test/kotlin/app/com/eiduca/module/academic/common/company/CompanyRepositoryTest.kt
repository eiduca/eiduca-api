package app.com.eiduca.module.academic.common.company

import app.com.eiduca.module.core.exception.NotFoundException

abstract class CompanyRepositoryTest <T: CompanyModel>(
    val repository: CompanyRepository<T>,
    val model: T
){

    fun findByName() {
        repository.save(model)
        repository.findByName(model.name).ifPresentOrElse({
            assert(it.name == model.name)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by name") })
    }

    fun findByEmail() {
        repository.save(model)
        repository.findByEmail(model.email).ifPresentOrElse({
            assert(it.email == model.email)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by email") })
    }

    fun findByAcronym() {
        repository.save(model)
        repository.findByAcronym(model.acronym).ifPresentOrElse({
            assert(it.acronym == model.acronym)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by acronym") })
    }

    fun findByContact() {
        repository.save(model)
        repository.findByContact(model.contact).ifPresentOrElse({
            assert(it.contact == model.contact)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by contact") })
    }

    fun findByWebsite() {
        repository.save(model)
        repository.findByWebsite(model.website).ifPresentOrElse({
            assert(it.website == model.website)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by website") })
    }

    fun findByFoundingDate() {
        repository.save(model)
        repository.findByFoundingDate(model.foundingDate).ifPresentOrElse({
            assert(it.foundingDate == model.foundingDate)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by foundingDate") })
    }
}