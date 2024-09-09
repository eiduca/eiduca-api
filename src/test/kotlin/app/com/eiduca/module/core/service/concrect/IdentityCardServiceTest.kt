package app.com.eiduca.module.core.service.concrect

import app.com.eiduca.module.core.common.ConcreteServiceTest
import app.com.eiduca.module.core.create.concrete.IdentityCardCreate
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.repository.concrect.IdentityCardRepository
import app.com.eiduca.module.core.repository.concrect.PersonRepository
import app.com.eiduca.module.core.util.AssertUtil
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.Optional
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@ExtendWith(SpringExtension::class)
@DisplayName("Test of identity card service")
class IdentityCardServiceTest: ConcreteServiceTest<IdentityCard>() {

    @InjectMocks
    lateinit var identityCardService: IdentityCardService

    @Mock
    lateinit var identityCardRepository: IdentityCardRepository

    @Mock
    lateinit var personRepository: PersonRepository

    @BeforeEach
    fun setUp() {
        setUpConcrete(identityCardService, identityCardRepository, IdentityCardCreate.IDENTITY_CARD_SAVE)
        val list = mutableListOf(model)
        val page = PageImpl(list)

        BDDMockito.`when`(identityCardRepository.findByCode(model.code)).thenReturn(Optional.of(model))
        BDDMockito.`when`(identityCardRepository.findByPerson(model.person)).thenReturn(list)
        BDDMockito.`when`(identityCardRepository.findByPerson(model.person, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(identityCardRepository.findByResidential(model.residential)).thenReturn(list)
        BDDMockito.`when`(identityCardRepository.findByResidential(model.residential, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(identityCardRepository.findByNaturalFrom(model.naturalFrom)).thenReturn(list)
        BDDMockito.`when`(identityCardRepository.findByNaturalFrom(model.naturalFrom, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(identityCardRepository.findByEmittedFrom(model.emittedFrom)).thenReturn(list)
        BDDMockito.`when`(identityCardRepository.findByEmittedFrom(model.emittedFrom, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(identityCardRepository.findByEmittedAt(model.emittedAt)).thenReturn(list)
        BDDMockito.`when`(identityCardRepository.findByEmittedAt(model.emittedAt, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(identityCardRepository.findByValidAt(model.validAt)).thenReturn(list)
        BDDMockito.`when`(identityCardRepository.findByValidAt(model.validAt, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(identityCardRepository.findByMaritalStatus(model.maritalStatus)).thenReturn(list)
        BDDMockito.`when`(identityCardRepository.findByMaritalStatus(model.maritalStatus, AssertUtil.PAGEABLE)).thenReturn(page)
        BDDMockito.`when`(personRepository.save(model.person)).thenReturn(model.person)
    }

    @Test
    @DisplayName("Find identity card by person when successful, list return")
    fun findByCode_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByCode(model.code))
    }

    @Test
    @DisplayName("Find identity card by person when successful, list return")
    fun findByPerson_ReturnList_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByPerson(model.person))
    }

    @Test
    @DisplayName("Find identity card by person when successful, list return pageable")
    fun findByPerson_ReturnPage_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByPerson(model.person, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find identity card by residential when successful, list return")
    fun findByResidential_ReturnList_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByResidential(model.residential))
    }

    @Test
    @DisplayName("Find identity card by residential when successful, list return pageable")
    fun findByResidential_ReturnPage_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByResidential(model.residential, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find identity card by naturalFrom when successful, list return")
    fun findByNaturalFrom_ReturnList_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByNaturalFrom(model.naturalFrom))
    }

    @Test
    @DisplayName("Find identity card by naturalFrom when successful, list return pageable")
    fun findByNaturalFrom_ReturnPage_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByNaturalFrom(model.naturalFrom, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find identity card by emittedIn when successful, list return")
    fun findByEmittedFrom_ReturnList_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByEmittedFrom(model.emittedFrom))
    }

    @Test
    @DisplayName("Find identity card by emittedIn when successful, list return pageable")
    fun findByEmittedFrom_ReturnPage_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByEmittedFrom(model.emittedFrom, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find identity card by emittedAt when successful, list return")
    fun findByEmittedAt_ReturnList_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByEmittedAt(model.emittedAt))
    }

    @Test
    @DisplayName("Find identity card by emittedAt when successful, list return pageable")
    fun findByEmittedAt_ReturnPage_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByEmittedAt(model.emittedAt, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find identity card by validAt when successful, list return")
    fun findByValidAt_ReturnList_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByValidAt(model.validAt))
    }

    @Test
    @DisplayName("Find identity card by validAt when successful, list return pageable")
    fun findByValidAt_ReturnPage_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByValidAt(model.validAt, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Find identity card by validAt when successful, list return")
    fun findByMaritalStatus_ReturnList_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByMaritalStatus(model.maritalStatus))
    }

    @Test
    @DisplayName("Find identity card by validAt when successful, list return pageable")
    fun findByMaritalStatus_ReturnPage_WhenSuccessful() {
        identityCardService.save(model)
        AssertUtil.assert(identityCardService.findByMaritalStatus(model.maritalStatus, AssertUtil.PAGEABLE))
    }

    @Test
    @DisplayName("Create or update identity card when successful")
    fun saveOrUpdate_WhenSuccessful() {
        val response = identityCardService.saveOrUpdate(model)
        assertNotNull(response.id)
        assertEquals(response, model)
    }
}