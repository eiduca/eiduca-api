package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.create.concrete.IdentityCardCreate
import app.com.eiduca.module.core.seed.IdentityCardSeed
import app.com.eiduca.module.core.service.concrect.IdentityCardService
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of identity card controller")
class IdentityCardControllerTest {

    @InjectMocks
    lateinit var identityCardController: IdentityCardController

    @Mock
    lateinit var identityCardService: IdentityCardService

    @BeforeEach
    fun setUp() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        val identityCards = PageImpl(IdentityCardSeed.entries.map { it.identityCard })
        BDDMockito.`when`(identityCardService.findAll(Pageable.ofSize(15))).thenReturn(identityCards)
        BDDMockito.`when`(identityCardService.findById(ArgumentMatchers.anyString())).thenReturn(identityCard)
        BDDMockito.`when`(identityCardService.save(identityCard)).thenReturn(identityCard)
        BDDMockito.doNothing().`when`(identityCardService).deleteById(ArgumentMatchers.anyString())
    }

    @Test
    @DisplayName("List pageable of identity cards when successful")
    fun findAll_WhenSuccessful() {
        val response = identityCardController.findAll(Pageable.ofSize(15))
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.isEmpty?.let { assertFalse(it) }
    }

    @Test
    @DisplayName("Find identity cards by id when successful")
    fun findById_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        val response = identityCardController.findById(identityCard.id)
        assertTrue(response.statusCode == ReturnStatus.OK)
        response.body?.let { assert(identityCard.id == it.id) }
    }

    @Test
    @DisplayName("Create identity cards when successful")
    fun save_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        val response = identityCardController.save(identityCard.toIdentityCardRequest())
        assertTrue(response.statusCode == ReturnStatus.CREATED)
        response.body?.let { assert(identityCard.person == it.person) }
    }

    @Test
    @DisplayName("Update identity cards when successful")
    fun update_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_UPDATE
        val response = identityCardController.update(identityCard.toIdentityCardRequest(), identityCard.id)
        assertTrue(response.statusCode == ReturnStatus.UPDATED)
        response.body?.let { assert(identityCard.person == it.person) }
    }

    @Test
    @DisplayName("Delete identity cards by id when successful")
    fun deleteById_WhenSuccessful() {
        val identityCard = IdentityCardCreate.IDENTITY_CARD_SAVE
        val response = identityCardController.deleteById(identityCard.id)
        assertTrue(response.statusCode == ReturnStatus.DELETED)
    }
}