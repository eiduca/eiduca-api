package app.com.eiduca.module.core.common.named

import app.com.eiduca.module.core.common.general.ConcreteRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface NamedDescriptionRepository<T: NamedDescriptionModel>: ConcreteRepository<T> {
    @Query(name = "ModelConcrete.findByName")
    fun findByName(name: String): Optional<T>

    @Query(name = "ModelConcrete.findByDescription")
    fun findByDescription(description: String): Optional<T>
}