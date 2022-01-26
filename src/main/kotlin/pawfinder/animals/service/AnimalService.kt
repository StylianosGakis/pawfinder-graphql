package pawfinder.animals.service

import org.springframework.stereotype.Service
import pawfinder.animals.AnimalType
import pawfinder.animals.Limit
import pawfinder.animals.mapping.fromPetFinderAnimal
import pawfinder.animals.model.Animal
import pawfinder.remote.petfinder.animal.api.PetFinderApi

@Service
class AnimalService(
    private val petFinderApi: PetFinderApi,
) {
    suspend fun animals(animalType: AnimalType, limit: Limit, page: Int): List<Animal> {
        val getAllAnimalsResponse = petFinderApi.fetchAnimals(
            animalType = animalType.toPetFinderAnimalType(),
            limit = limit.toPetFinderLimit(),
            page = page,
        )
        return getAllAnimalsResponse.animals.map(Animal::fromPetFinderAnimal)
    }

    suspend fun animal(id: String): Animal {
        val getOnePetFinderAnimalResponse = petFinderApi.fetchAnimal(id)
        return Animal.fromPetFinderAnimal(getOnePetFinderAnimalResponse.animal)
    }
}
