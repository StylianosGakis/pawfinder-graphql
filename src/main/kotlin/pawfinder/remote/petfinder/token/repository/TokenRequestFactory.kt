package pawfinder.remote.petfinder.token.repository

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pawfinder.remote.petfinder.PetFinderProperties
import pawfinder.remote.petfinder.token.request.TokenRequest

@Configuration
class TokenRequestFactory(
    val petFinderProperties: PetFinderProperties,
) {

    @Bean
    fun createTokenRequest(): TokenRequest {
        return TokenRequest.create(
            petFinderProperties.id,
            petFinderProperties.secret
        )
    }
}
