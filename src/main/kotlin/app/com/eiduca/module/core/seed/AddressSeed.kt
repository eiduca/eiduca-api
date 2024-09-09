package app.com.eiduca.module.core.seed

import app.com.eiduca.module.core.factory.AddressFactory
import app.com.eiduca.module.core.model.concrect.Address

enum class AddressSeed(val address: Address) {
    DEFAULT(AddressFactory.build("d44fa24fc580")),
}