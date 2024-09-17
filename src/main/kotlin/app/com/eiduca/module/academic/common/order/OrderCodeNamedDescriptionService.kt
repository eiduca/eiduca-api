package app.com.eiduca.module.academic.common.order

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionService
import app.com.eiduca.module.core.exception.NotFoundException

abstract class OrderCodeNamedDescriptionService<T: OrderCodeNamedDescriptionModel>(
    private val orderCodeNamedDescriptionRepository: OrderCodeNamedDescriptionRepository<T>,
): CodeNamedDescriptionService<T>(orderCodeNamedDescriptionRepository) {

    fun findByNumb(numb: Int): T = orderCodeNamedDescriptionRepository.findByNumb(numb).orElseThrow { NotFoundException("Not found orderCodeNamedDescription by order") }

}