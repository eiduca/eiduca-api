package app.com.eiduca.module.core.integration.concrete

import app.com.eiduca.annotation.EiConfigureTestIT
import app.com.eiduca.module.core.common.general.CommonModel
import app.com.eiduca.module.core.common.general.ConcreteControllerItTest
import app.com.eiduca.module.core.create.concrete.IdentityCardCreate
import app.com.eiduca.module.core.model.concrect.IdentityCard
import app.com.eiduca.module.core.request.IdentityCardRequest
import app.com.eiduca.module.core.service.concrect.IdentityCardService
import app.com.eiduca.module.core.service.concrect.PersonService
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

@EiConfigureTestIT
@DisplayName("Test integration of identity card")
class IdentityCardControllerIT(
    @Autowired val identityCardService: IdentityCardService,
    @Autowired val personService: PersonService,
): ConcreteControllerItTest<IdentityCard>(
    identityCardService,
    IdentityCardCreate.IDENTITY_CARD_NOT_EXIST,
    "identity-cards"
) {
    override fun requestModel(): IdentityCardRequest = model.toIdentityCardRequest()

    override fun runner() {
        model.person = personService.saveOrUpdate(model.person)
    }
}