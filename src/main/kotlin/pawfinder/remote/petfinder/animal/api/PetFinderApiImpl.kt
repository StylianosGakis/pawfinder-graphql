package pawfinder.remote.petfinder.animal.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.springframework.stereotype.Service
import pawfinder.remote.petfinder.PetFinderProperties
import pawfinder.remote.petfinder.animal.response.GetAllAnimalsResponse
import pawfinder.remote.petfinder.animal.response.GetOneAnimalResponse
import pawfinder.remote.petfinder.token.repository.TokenRepository

@Service
class PetFinderApiImpl(
    private val petFinderProperties: PetFinderProperties,
    private val client: HttpClient,
    private val tokenRepository: TokenRepository,
) : PetFinderApi {

    override suspend fun fetchAnimals(
        animalType: AnimalType,
        limit: Limit,
        page: Int,
    ): GetAllAnimalsResponse {
        val response = client.get("${petFinderProperties.baseurl}/animals") {
            parameter("type", animalType.parameterName)
            parameter("limit", limit.value)
            parameter("page", page)
            bearerAuth(tokenRepository.getBearerToken())
        }
        return response.body()
    }

    override suspend fun fetchAnimal(id: String): GetOneAnimalResponse {
        val response = client.get("${petFinderProperties.baseurl}/animals/$id") {
            bearerAuth(tokenRepository.getBearerToken())
        }
        return response.body()
    }
}
