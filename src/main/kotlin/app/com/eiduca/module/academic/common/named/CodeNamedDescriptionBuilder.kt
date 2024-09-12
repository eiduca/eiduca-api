package app.com.eiduca.module.academic.common.named

import app.com.eiduca.module.core.common.general.ConcreteBuilder

abstract class CodeNamedDescriptionBuilder<T: CodeNamedDescriptionModel> : ConcreteBuilder<T>(){

    protected var code: String = ""
    protected var name: String = ""
    protected var description: String? = null

    fun code(code: String) = apply { this.code = code }

    fun name(name: String) = apply { this.name = name }

    fun description(description: String?) = apply { this.description = description }

    protected fun <T : CodeNamedDescriptionModel> withDefaultValues(obj: T): T {
        obj.description = description
        obj.code = code
        obj.name = name
        return super.withDefaultValues(obj)
    }

}