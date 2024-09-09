package app.com.eiduca.module.core.interfaces

import app.com.eiduca.module.core.common.general.CommonModel

interface IConvertModel <T: CommonModel> {
    fun toModel(): T
}