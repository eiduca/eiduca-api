package app.com.eiduca.configuration.annotation

import app.com.eiduca.module.core.seed.PermissionSeed
import org.springframework.stereotype.Component
import java.lang.annotation.Inherited

@Component
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class HasPermission(
    val permissionSeed: PermissionSeed
)
