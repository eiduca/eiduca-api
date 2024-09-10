package app.com.eiduca.configuration.annotation

import app.com.eiduca.configuration.constant.ProjectConst
import org.springframework.web.bind.annotation.CrossOrigin
import java.lang.annotation.Inherited

@Inherited
@CrossOrigin(ProjectConst.CROSS_ORIGIN)
annotation class EiCrossOrigin {
}