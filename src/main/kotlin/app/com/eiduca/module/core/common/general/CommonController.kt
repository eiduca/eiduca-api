package app.com.eiduca.module.core.common.general

import app.com.eiduca.module.core.interfaces.IConvertModel
import jakarta.persistence.MappedSuperclass
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

@MappedSuperclass
abstract class CommonController<T: CommonModel, R: IConvertModel<T>> {

    open fun findAll(pageable: Pageable): ResponseEntity<Page<T>> = ResponseEntity.noContent().build()

    open fun findById(id: String): ResponseEntity<T> = ResponseEntity.noContent().build()

    open fun save(request: R): ResponseEntity<T> = ResponseEntity.ok(request.toModel())

    open fun update(request: R, id: String): ResponseEntity<T> = ResponseEntity.ok(request.toModel())

    open fun deleteById(id: String): ResponseEntity<Unit> = ResponseEntity.noContent().build()
}

@MappedSuperclass
abstract class ConcreteController<T: ConcreteModel, R: IConvertModel<T>>: CommonController<T, R>() {
}

@MappedSuperclass
abstract class PivotController<T: PivotModel, R: IConvertModel<T>>: CommonController<T, R>() {
}