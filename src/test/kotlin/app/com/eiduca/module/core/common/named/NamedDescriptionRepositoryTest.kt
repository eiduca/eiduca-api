package app.com.eiduca.module.core.common.named

import app.com.eiduca.module.core.common.general.ConcreteRepositoryTest
import app.com.eiduca.module.core.exception.NotFoundException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Test namedDescription repository")
abstract class NamedDescriptionRepositoryTest<T: NamedDescriptionModel>(
    var namedDescriptionRepository: NamedDescriptionRepository<T>,
    model: T
): ConcreteRepositoryTest<T>(namedDescriptionRepository,model) {

    @Test
    fun findByName_ReturnObject_WhenSuccessful(){
        runner()
        persistModel()
        namedDescriptionRepository.findByName(model.name).ifPresentOrElse(
            { assertEquals(it.name,model.name) },
            { throw NotFoundException("Not found namedDescription by name") }
        )
    }

    @Test
    fun findByDescription_ReturnObject_WhenSuccessful(){
        runner()
        persistModel()
        namedDescriptionRepository.findByDescription(model.description).ifPresentOrElse(
            { assertEquals(it.description, model.description) },
            { throw NotFoundException("Not found namedDescription by description") }
        )
    }

    override fun runner() = namedDescriptionRepository.deleteAll()

    override fun persistModel() {
        model = namedDescriptionRepository.findByName(model.name).orElse(namedDescriptionRepository.save(model))
    }
}