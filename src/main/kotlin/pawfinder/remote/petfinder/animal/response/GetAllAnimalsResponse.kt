package pawfinder.remote.petfinder.animal.response

import kotlinx.serialization.Serializable
import pawfinder.remote.petfinder.animal.response.model.Animal
import pawfinder.remote.petfinder.animal.response.model.Pagination

@Serializable
data class GetAllAnimalsResponse(
    val animals: List<Animal>,
    val pagination: Pagination,
)
