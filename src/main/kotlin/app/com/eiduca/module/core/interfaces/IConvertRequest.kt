package app.com.eiduca.module.core.interfaces

interface IConvertRequest<T> {
    fun toRequest(): T
}