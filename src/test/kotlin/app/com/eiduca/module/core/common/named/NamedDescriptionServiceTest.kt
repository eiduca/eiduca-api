package app.com.eiduca.module.core.common.named

import app.com.eiduca.module.core.common.general.ConcreteServiceTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.BDDMockito
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

abstract class NamedDescriptionServiceTest<T: NamedDescriptionModel>: ConcreteServiceTest<T>() {

    private lateinit var namedDescriptionService: NamedDescriptionService<T>
    private lateinit var namedDescriptionRepository: NamedDescriptionRepository<T>

    fun setUpNamedDescription(namedDescriptionService: NamedDescriptionService<T>, namedDescriptionRepository: NamedDescriptionRepository<T>, model: T) {
        setUpConcrete(namedDescriptionService, namedDescriptionRepository, model)

        this.namedDescriptionRepository = namedDescriptionRepository
        this.namedDescriptionService = namedDescriptionService

        BDDMockito.`when`(namedDescriptionRepository.findByName(model.name)).thenReturn(Optional.of(model))
        BDDMockito.`when`(namedDescriptionRepository.findByDescription(model.description)).thenReturn(Optional.of(model))
    }

    @Test
    @DisplayName("Find namedDescription by name when successful")
    fun findByName_WhenSuccessful() {
        assertDoesNotThrow {
            val response = namedDescriptionService.findByName(model.name)
            assertEquals(response.name, model.name)
        }
    }

    @Test
    @DisplayName("Find namedDescription by description when successful")
    fun findByDescription_WhenSuccessful() {
        assertDoesNotThrow {
            val response = namedDescriptionService.findByDescription(model.description)
            assertEquals(response.description, model.description)
        }
    }

    @Test
    @DisplayName("Create or update namedDescription when successful")
    fun saveOrUpdate_WhenSuccessful() {
        assertDoesNotThrow {
            val response = namedDescriptionService.saveOrUpdate(model)
            assertNotNull(response.id)
            assertEquals(response.name, model.name)
        }
    }
}