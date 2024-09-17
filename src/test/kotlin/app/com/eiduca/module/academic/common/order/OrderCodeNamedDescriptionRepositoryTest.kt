package app.com.eiduca.module.academic.common.order

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionRepositoryTest
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Test orderCodeNamedDescription repository")
abstract class OrderCodeNamedDescriptionRepositoryTest<T: OrderCodeNamedDescriptionModel>(
    private val orderCodeNamedDescriptionRepository: OrderCodeNamedDescriptionRepository<T>,
    model: T,
): CodeNamedDescriptionRepositoryTest<T>(orderCodeNamedDescriptionRepository, model) {
    @Test
    fun findByNumb_ReturnObject_WhenSuccessful() {
        runner()
        persistModel()
        orderCodeNamedDescriptionRepository.findByNumb(model.numb).ifPresentOrElse(
            { assert(it == model) },
            { throw NotFoundException("Not found curriculumYear by numb") }
        )
    }
}