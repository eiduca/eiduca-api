package app.com.eiduca.module.core.interfaces

import app.com.eiduca.module.core.util.GeneratorINT
import app.com.eiduca.module.core.util.GeneratorNanoID

interface IUniqueAttributeModifier {
    fun updateUniqueAttributes()

    fun nanoId(): String = "#${GeneratorNanoID.random()}"

    fun intNumb(): Int = GeneratorINT.DEFAULT_INT_HIDDEN
}