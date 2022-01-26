package pawfinder.remote.petfinder.animal.api

import pawfinder.remote.petfinder.animal.response.GetAllAnimalsResponse
import pawfinder.remote.petfinder.animal.response.GetOneAnimalResponse

interface PetFinderApi {
    suspend fun fetchAnimals(animalType: AnimalType, limit: Limit, page: Int): GetAllAnimalsResponse
    suspend fun fetchAnimal(id: String): GetOneAnimalResponse
}

enum class AnimalType(val parameterName: String) {
    DOG("Dog"),
    CAT("Cat"),
    RABBIT("Rabbit"),
    SMALL("Small & Furry"),
    HORSE("Horse"),
    BIRD("Bird"),
    SCALES("Scales, Fins & Other"),
    BARNYARD("Barnyard"),
}


@JvmInline
value class Limit(val value: Int) {
    init {
        require(value in 1..100)
    }
}
