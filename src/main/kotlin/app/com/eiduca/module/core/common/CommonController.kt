package app.com.eiduca.module.core.common

import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class CommonController {
}

@MappedSuperclass
abstract class ConcreteController: CommonController() {
}

@MappedSuperclass
abstract class PivotController: CommonController() {
}