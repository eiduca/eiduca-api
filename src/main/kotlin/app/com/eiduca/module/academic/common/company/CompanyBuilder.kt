package app.com.eiduca.module.academic.common.company

import app.com.eiduca.module.core.common.general.ConcreteBuilder
import java.time.LocalDate

abstract  class CompanyBuilder <T: CompanyModel>: ConcreteBuilder<T>() {

    protected var name: String = ""
    protected var acronym: String = ""
    protected var email: String = ""
    protected var contact: String = ""
    protected var website: String = ""
    protected var foundingDate: LocalDate = LocalDate.now()
    protected var latitude: Double? = null
    protected var longitude: Double? = null

    fun name(name: String) = apply{ this.name = name }

    fun acronym(acronym: String) = apply{ this.acronym = acronym }

    fun email(email: String) = apply{ this.email = email }

    fun contact(contact: String) = apply{ this.contact = contact }

    fun website(website: String) = apply{ this.website = website }

    fun foundingDate(foundingDate: LocalDate) = apply{ this.foundingDate = foundingDate }

    fun latitude(latitude: Double? = null) = apply{ this.latitude = latitude }

    fun longitude(longitude: Double? = null) = apply{ this.longitude = longitude }

    protected fun <T : CompanyModel> withDefaultValues(obj: T): T {
        obj.name = name
        obj.acronym = acronym
        obj.email = email
        obj.contact = contact
        obj.website = website
        obj.foundingDate = foundingDate
        return  super.withDefaultValues(obj)
    }

}