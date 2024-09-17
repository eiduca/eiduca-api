package app.com.eiduca.module.academic.common.order

import app.com.eiduca.module.academic.common.named.CodeNamedDescriptionBuilder

abstract class OrderCodeNamedDescriptionBuilder<T: OrderCodeNamedDescriptionModel> : CodeNamedDescriptionBuilder<T>(){
    protected var numb: Int = 0

    fun numb(numb: Int) = apply { this.numb = numb }

    protected fun <T : OrderCodeNamedDescriptionModel> withDefaultValues(obj: T): T {
        obj.numb = numb
        return super.withDefaultValues(obj)
    }
}