package app.com.eiduca.module.academic.common.named

import app.com.eiduca.module.core.common.general.ConcreteRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface CodeNamedDescriptionRepository<T: CodeNamedDescriptionModel>  : ConcreteRepository<T> {

    @Query(name = "ModelConcrete.findByCode")
    fun findByCode(code: String): Optional<T>

    @Query(name = "ModelConcrete.findByName")
    fun findByName(name: String): Optional<T>

    @Query(name = "ModelConcrete.findByDescription")
    fun findByDescription(description: String): List<T>

    @Query(name = "ModelConcrete.findByDescription", countName = "ModelConcrete.findByDescriptionCount")
    fun findByDescription(description: String, pageable: Pageable): Page<T>
}
