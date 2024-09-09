package app.com.eiduca.module.core.util

import com.aventrix.jnanoid.jnanoid.NanoIdUtils

class GeneratorNanoID {

    companion object{

        fun random() = NanoIdUtils.randomNanoId()

    }

}