package app.com.eiduca.module.core.common.general

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.util.Optional

@NoRepositoryBean
interface  CommonRepository <T: CommonModel> : JpaRepository<T, String>

@NoRepositoryBean
interface  ConcreteRepository <T: ConcreteModel> : CommonRepository<T> {

    @Query(name = "ModelConcrete.findAll", countName = "ModelConcrete.findAllCount")
    override fun findAll(pageable: Pageable): Page<T>

    @Query(name = "ModelConcrete.findById")
    override fun findById(id: String): Optional<T>
}

@NoRepositoryBean
interface PivotRepository <T: PivotModel> : CommonRepository<T>