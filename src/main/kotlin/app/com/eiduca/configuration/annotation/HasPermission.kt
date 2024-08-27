package app.com.eiduca.configuration.annotation

import app.com.eiduca.module.core.seed.PermissionSeed
import org.springframework.stereotype.Component

@Component
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class HasPermission(
    val permissionSeed: PermissionSeed
)
