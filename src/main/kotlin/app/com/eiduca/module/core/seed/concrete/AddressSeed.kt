package app.com.eiduca.module.core.seed.concrete

import app.com.eiduca.module.core.factory.concrete.AddressFactory
import app.com.eiduca.module.core.model.concrect.Address

enum class AddressSeed(val address: Address) {
    DEFAULT(AddressFactory.build()),
}