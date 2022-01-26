package pawfinder.remote.petfinder.animal.response

import kotlinx.serialization.Serializable
import pawfinder.remote.petfinder.animal.response.model.Animal

@Serializable
data class GetOneAnimalResponse(
    val animal: Animal,
)
