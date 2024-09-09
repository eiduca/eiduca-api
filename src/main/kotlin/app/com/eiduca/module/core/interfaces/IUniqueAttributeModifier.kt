package app.com.eiduca.module.core.interfaces

import app.com.eiduca.module.core.util.GeneratorNanoID

interface IUniqueAttributeModifier {
    fun updateUniqueAttributes()

    fun nanoId(): String = "#${GeneratorNanoID.random()}"
}