package app.com.eiduca.module.academic.common.company

import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Test company repository")
abstract class CompanyRepositoryTest <T: CompanyModel>(
    var companyRepository: CompanyRepository<T>,
    model: T
): ConcreteRepositoryTest<T>(companyRepository, model) {

    @Test
    fun findByName_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        companyRepository.findByName(model.name).ifPresentOrElse({
            assert(it.name == model.name)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by name") })
    }

    @Test
    fun findByAcronym_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        companyRepository.findByAcronym(model.acronym).ifPresentOrElse({
            assert(it.acronym == model.acronym)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by acronym") })
    }

    @Test
    fun findByEmail_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByEmail(model.email))
    }

    @Test
    fun findByEmail_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByEmail(model.email, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByContact_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByContact(model.contact))
    }

    @Test
    fun findByContact_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByContact(model.contact, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByWebsite_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByWebsite(model.website))
    }

    @Test
    fun findByWebsite_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByWebsite(model.website, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByFoundingDate_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByFoundingDate(model.foundingDate))
    }

    @Test
    fun findByFoundingDate_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByFoundingDate(model.foundingDate, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByLatitude_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByLatitude(model.latitude))
    }

    @Test
    fun findByLatitude_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByLatitude(model.latitude, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByLongitude_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByLongitude(model.longitude))
    }

    @Test
    fun findByLongitude_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(companyRepository.findByLongitude(model.longitude, AssertUtil.PAGEABLE))
    }

    override fun runner() = companyRepository.deleteAll()

    override fun persistModel(){
        model = companyRepository.findByName(model.name).orElse(companyRepository.save(model))
    }
}