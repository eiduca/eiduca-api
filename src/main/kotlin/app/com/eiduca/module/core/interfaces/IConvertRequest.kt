package app.com.eiduca.module.core.interfaces

import app.com.eiduca.module.core.common.general.CommonModel

interface IConvertRequest<T: CommonModel> {
    fun toRequest(): IConvertModel<T>
}