package pawfinder.remote.petfinder.token.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.springframework.stereotype.Service
import pawfinder.remote.petfinder.PetFinderProperties
import pawfinder.remote.petfinder.token.repository.TokenRequestFactory
import pawfinder.remote.petfinder.token.response.TokenResponse

@Service
class TokenApiImpl(
    private val tokenRequestFactory: TokenRequestFactory,
    private val petFinderProperties: PetFinderProperties,
    private val client: HttpClient,
) : TokenApi {
    override suspend fun getToken(): TokenResponse {
        val tokenRequest = tokenRequestFactory.createTokenRequest()
        return client
            .post("${petFinderProperties.baseurl}/oauth2/token") {
                contentType(ContentType.Application.Json)
                setBody(tokenRequest)
            }
            .body()
    }
}
