package app.com.eiduca.module.core.common.named

import app.com.eiduca.module.core.common.general.ConcreteBuilder

abstract class NamedDescriptionBuilder<T: NamedDescriptionModel> : ConcreteBuilder<T>() {

    protected var name: String = ""
    protected var description: String = ""

    fun name(name: String) = apply{ this.name = name }

    fun description(description: String) = apply{ this.description = description }

    fun <T : NamedDescriptionModel> withDefaultValues(obj: T): T {
        val param = super.withDefaultValues(obj)
        param.description = description
        param.name = name
        return param
    }
}