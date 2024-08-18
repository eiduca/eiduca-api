package app.com.eiduca.module.core.util

import com.github.f4b6a3.uuid.UuidCreator

class GeneratorUUID {

    companion object{

        fun v7toString(): String = UuidCreator.getTimeOrderedEpoch().toString()

    }

}