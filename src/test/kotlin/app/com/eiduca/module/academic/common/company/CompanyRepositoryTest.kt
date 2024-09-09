package app.com.eiduca.module.academic.common.company

import app.com.eiduca.module.core.exception.NotFoundException
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.transaction.annotation.Transactional

@Transactional
abstract class CompanyRepositoryTest <T: CompanyModel>(
    var repository: CompanyRepository<T>,
    var model: T
){
    @Test
    @DisplayName("Find company by name when successful")
    fun findByName_WhenSuccessful() {
        runner()
        persistModel()
        repository.findByName(model.name).ifPresentOrElse({
            assert(it.name == model.name)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by name") })
    }

    @Test
    @DisplayName("Find company by acronym when successful")
    fun findByAcronym_WhenSuccessful() {
        runner()
        persistModel()
        repository.findByAcronym(model.acronym).ifPresentOrElse({
            assert(it.acronym == model.acronym)
        }, {throw NotFoundException("Not found ${model.javaClass.simpleName} by acronym") })
    }

    @Test
    @DisplayName("Find company by email when successful, return list")
    fun findByEmail_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByEmail(model.email))
    }

    @Test
    @DisplayName("Find company by email when successful, return list pageable")
    fun findByEmail_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByEmail(model.email, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find company by contact when successful, return list")
    fun findByContact_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByContact(model.contact))
    }

    @Test
    @DisplayName("Find company by contact when successful, return list pageable")
    fun findByContact_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByContact(model.contact, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find company by website when successful, return list")
    fun findByWebsite_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByWebsite(model.website))
    }

    @Test
    @DisplayName("Find company by website when successful, return list pageable")
    fun findByWebsite_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByWebsite(model.website, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find company by foundingDate when successful, return list")
    fun findByFoundingDate_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByFoundingDate(model.foundingDate))
    }

    @Test
    @DisplayName("Find company by foundingDate when successful, return list pageable")
    fun findByFoundingDate_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByFoundingDate(model.foundingDate, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find company by latitude when successful, return list")
    fun findByLatitude_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByLatitude(model.latitude))
    }

    @Test
    @DisplayName("Find company by latitude when successful, return list pageable")
    fun findByLatitude_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByLatitude(model.latitude, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find company by longitude when successful, return list")
    fun findByLongitude_ReturnList_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByLongitude(model.longitude))
    }

    @Test
    @DisplayName("Find company by longitude when successful, return list pageable")
    fun findByLongitude_ReturnPage_WhenSuccessful() {
        runner()
        persistModel()
        AssertUtil.assert(repository.findByLongitude(model.longitude, AssertUtil.PAGEABLE))
    }

    fun persistModel(){
        model = repository.save(model)
    }

    fun runner(){}
}