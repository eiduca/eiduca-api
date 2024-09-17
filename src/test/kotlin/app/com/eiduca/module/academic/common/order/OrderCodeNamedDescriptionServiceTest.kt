package app.com.eiduca.module.academic.common.order

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionServiceTest
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import java.util.*

@DisplayName("Test orderCodeNamedDescription service")
abstract class OrderCodeNamedDescriptionServiceTest<T: OrderCodeNamedDescriptionModel>: CodeNamedDescriptionServiceTest<T>() {

    private lateinit var orderCodeNamedDescriptionService: OrderCodeNamedDescriptionService<T>
    private lateinit var orderCodeNamedDescriptionRepository: OrderCodeNamedDescriptionRepository<T>

    fun setUpOrderCodeNamedDescription(orderCodeNamedDescriptionService: OrderCodeNamedDescriptionService<T>, orderCodeNamedDescriptionRepository: OrderCodeNamedDescriptionRepository<T>, model: T) {
        setUpCodeNamedDescription(orderCodeNamedDescriptionService, orderCodeNamedDescriptionRepository, model)
        this.orderCodeNamedDescriptionService = orderCodeNamedDescriptionService
        this.orderCodeNamedDescriptionRepository = orderCodeNamedDescriptionRepository
        this.model = model
        BDDMockito.`when`(orderCodeNamedDescriptionRepository.findByNumb(model.numb)).thenReturn(Optional.of(model))
    }

    @Test
    fun findByNumb_ReturnObject_WhenSuccessful() {
        assertDoesNotThrow {
            val curriculumYearFind = orderCodeNamedDescriptionService.findOrSave(model)
            val curriculumYearSave = orderCodeNamedDescriptionService.findByNumb(model.numb)
            assertEquals(curriculumYearFind, curriculumYearSave)
        }
    }
}