package pawfinder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class PawFinderApplication

fun main(args: Array<String>) {
    runApplication<PawFinderApplication>(*args)
}
