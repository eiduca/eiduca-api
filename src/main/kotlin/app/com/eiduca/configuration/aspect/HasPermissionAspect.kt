package app.com.eiduca.configuration.aspect

import app.com.eiduca.configuration.annotation.HasPermission
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class HasPermissionAspect {

    @Before("@annotation(hasPermission)")
    fun checkPermission(joinPoint: JoinPoint, hasPermission: HasPermission) {
        val permissionSeed = hasPermission.permissionSeed
        println("Permission Seed: $permissionSeed")
    }

}