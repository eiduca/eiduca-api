package app.com.eiduca.module.academic.common.order

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface OrderCodeNamedDescriptionRepository<T: OrderCodeNamedDescriptionModel>  : CodeNamedDescriptionRepository<T> {
    @Query(name = "ModelConcrete.findByNumb")
    fun findByNumb(numb: Int): Optional<T>
}
