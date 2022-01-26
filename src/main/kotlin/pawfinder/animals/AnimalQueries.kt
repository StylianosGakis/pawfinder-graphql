package pawfinder.animals

import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component
import pawfinder.animals.model.Animal
import pawfinder.animals.service.AnimalService
import pawfinder.remote.petfinder.animal.api.AnimalType as PetFinderAnimalType
import pawfinder.remote.petfinder.animal.api.Limit as PetFinderLimit

@Component
class AnimalQueries(
    private val animalService: AnimalService,
) : Query {

    @Suppress("unused")
    suspend fun animals(
        animalType: AnimalType,
        limit: Limit = Limit(20),
        page: Int = 1,
    ): List<Animal> {
        return animalService.animals(animalType, limit, page)
    }

    @Suppress("unused")
    suspend fun animal(
        id: String,
    ): Animal {
        return animalService.animal(id)
    }
}

enum class AnimalType {
    DOG,
    CAT,
    RABBIT,
    SMALL,
    HORSE,
    BIRD,
    SCALES,
    BARNYARD,
    ;

    fun toPetFinderAnimalType(): PetFinderAnimalType {
        return when (this) {
            DOG -> PetFinderAnimalType.DOG
            CAT -> PetFinderAnimalType.CAT
            RABBIT -> PetFinderAnimalType.RABBIT
            SMALL -> PetFinderAnimalType.SMALL
            HORSE -> PetFinderAnimalType.HORSE
            BIRD -> PetFinderAnimalType.BIRD
            SCALES -> PetFinderAnimalType.SCALES
            BARNYARD -> PetFinderAnimalType.BARNYARD
        }
    }
}

data class Limit(val value: Int) {
    init {
        require(value in 1..100)
    }

    fun toPetFinderLimit(): PetFinderLimit {
        return PetFinderLimit(this.value)
    }
}
