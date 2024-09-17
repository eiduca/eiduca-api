package app.com.eiduca.module.academic.common.company

import app.com.eiduca.module.core.common.general.ConcreteServiceTest
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.data.domain.PageImpl
import java.util.*

@DisplayName("Test company service")
abstract class CompanyServiceTest <T: CompanyModel>: ConcreteServiceTest<T>(){

    private lateinit var companyService: CompanyService<T>
    private lateinit var companyRepository: CompanyRepository<T>

    fun setUpCompany(companyService: CompanyService<T>, companyRepository: CompanyRepository<T>, model: T) {
        setUpConcrete(companyService, companyRepository, model)
        this.companyRepository = companyRepository
        this.companyService = companyService

        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(companyRepository.findByAcronym(model.acronym)).thenReturn(Optional.of(model))
        BDDMockito.`when`(companyRepository.findByName(model.name)).thenReturn(Optional.of(model))
        BDDMockito.`when`(companyRepository.findByEmail(model.email)).thenReturn(list)
        BDDMockito.`when`(companyRepository.findByEmail(model.email, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(companyRepository.findByContact(model.contact)).thenReturn(list)
        BDDMockito.`when`(companyRepository.findByContact(model.contact, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(companyRepository.findByWebsite(model.website)).thenReturn(list)
        BDDMockito.`when`(companyRepository.findByWebsite(model.website, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(companyRepository.findByFoundingDate(model.foundingDate)).thenReturn(list)
        BDDMockito.`when`(companyRepository.findByFoundingDate(model.foundingDate, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(companyRepository.findByLatitude(model.latitude)).thenReturn(list)
        BDDMockito.`when`(companyRepository.findByLatitude(model.latitude, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(companyRepository.findByLongitude(model.longitude)).thenReturn(list)
        BDDMockito.`when`(companyRepository.findByLongitude(model.longitude, AssertUtil.PAGEABLE)).thenReturn(page)
    }

    @Test
    fun findByName_ReturnObject_WhenSuccessful() {
        assertDoesNotThrow {
            val companySave = companyService.save(model)
            val companyFound = companyService.findByName(model.name)
            assertEquals(companySave,companyFound)
        }
    }

    @Test
    fun findByAcronym_ReturnObject_WhenSuccessful() {
        assertDoesNotThrow {
            val companySave = companyService.save(model)
            val companyFound = companyService.findByAcronym(model.acronym)
            assertEquals(companySave,companyFound)
        }
    }

    @Test
    fun findByEmail_ReturnList_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByEmail(model.email))
    }

    @Test
    fun findByEmail_ReturnPage_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByEmail(model.email, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByContact_ReturnList_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByContact(model.contact))
    }

    @Test
    fun findByContact_ReturnPage_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByContact(model.contact, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByWebsite_ReturnList_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByWebsite(model.website))
    }

    @Test
    fun findByWebsite_ReturnPage_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByWebsite(model.website, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByFoundingDate_ReturnList_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByFoundingDate(model.foundingDate))
    }

    @Test
    fun findByFoundingDate_ReturnPage_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByFoundingDate(model.foundingDate, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByLatitude_ReturnList_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByLatitude(model.latitude))
    }

    @Test
    fun findByLatitude_ReturnPage_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByLatitude(model.latitude, AssertUtil.PAGEABLE))
    }

    @Test
    fun findByLongitude_ReturnList_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByLongitude(model.longitude))
    }

    @Test
    fun findByLongitude_ReturnPage_WhenSuccessful() {
        companyService.save(model)
        AssertUtil.assert(companyService.findByLongitude(model.longitude, AssertUtil.PAGEABLE))
    }
}