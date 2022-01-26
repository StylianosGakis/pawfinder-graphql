package pawfinder.remote.petfinder

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "configuration.token.petfinderclient")
data class PetFinderProperties(
    val baseurl: String,
    val id: String,
    val secret: String,
)
