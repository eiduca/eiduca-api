package app.com.eiduca.module.core.controller.concrect

import app.com.eiduca.module.core.common.general.ConcreteControllerTest
import app.com.eiduca.module.core.create.concrete.IdentityCardCreate
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.request.IdentityCardRequest
import app.com.eiduca.module.core.service.concrect.IdentityCardService

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DisplayName("Test of identity card controller")
class IdentityCardControllerTest: ConcreteControllerTest<IdentityCard, IdentityCardRequest>(){

    @InjectMocks
    lateinit var identityCardController: IdentityCardController

    @Mock
    lateinit var identityCardService: IdentityCardService

    @BeforeEach
    fun setUpIdentityCard() {
        setUpConcrete(identityCardController, identityCardService, IdentityCardCreate.IDENTITY_CARD_SAVE)
    }

    override fun createModel(): ResponseEntity<IdentityCard> = identityCardController.save(model.toRequest())

    override fun updateModel(): ResponseEntity<IdentityCard> = identityCardController.update(model.toRequest(), model.id)
}