package app.com.eiduca.module.core.interfaces

import com.aventrix.jnanoid.jnanoid.NanoIdUtils

interface IUniqueAttributeModifier {
    fun updateUniqueAttributes()

    fun nanoId(): String = "#${NanoIdUtils.randomNanoId()}"
}