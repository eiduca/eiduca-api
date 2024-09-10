package app.com.eiduca.module.core.common.general

import app.com.eiduca.configuration.annotation.*
import app.com.eiduca.module.core.constant.ReturnStatus
import app.com.eiduca.module.core.interfaces.IConvertModel
import jakarta.persistence.MappedSuperclass
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

@EiCrossOrigin
@MappedSuperclass
abstract class CommonController<T: CommonModel, R: IConvertModel<T>>(
    private val commonService: CommonService<T>
) {

    @FindAllRequest
    open fun findAll(pageable: Pageable): ResponseEntity<Page<T>> = ResponseEntity(commonService.findAll(pageable), ReturnStatus.OK)

    @FindByIdRequest
    open fun findById(id: String): ResponseEntity<T> = ResponseEntity(commonService.findById(id), ReturnStatus.OK)

    @SaveRequest
    open fun save(request: R): ResponseEntity<T> = ResponseEntity(commonService.save(request.toModel()), ReturnStatus.CREATED)

    @UpdateRequest
    open fun update(request: R, id: String): ResponseEntity<T> = ResponseEntity(commonService.update(request.toModel(),id), ReturnStatus.UPDATED)

    @DeletedByIdRequest
    open fun deleteById(id: String): ResponseEntity<Unit>  = ResponseEntity(commonService.deleteById(id), ReturnStatus.DELETED)
}

@MappedSuperclass
abstract class ConcreteController<T: ConcreteModel, R: IConvertModel<T>>(
    private val concreteService: ConcreteService<T>
): CommonController<T, R>(concreteService){

    override fun update(request: R, id: String): ResponseEntity<T>{
        return ResponseEntity(concreteService.update(request.toModel(),id), ReturnStatus.UPDATED)
    }

    override fun deleteById(id: String): ResponseEntity<Unit> {
        return ResponseEntity(concreteService.deleteById(id), ReturnStatus.DELETED)
    }
}

@MappedSuperclass
abstract class PivotController<T: PivotModel, R: IConvertModel<T>>(
    service: CommonService<T>
): CommonController<T, R>(service)