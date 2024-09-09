package app.com.eiduca

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.boot.runApplication

@EnableCaching
@SpringBootApplication
class EiducaApplication

fun main(args: Array<String>) {
	runApplication<EiducaApplication>(*args)
}
