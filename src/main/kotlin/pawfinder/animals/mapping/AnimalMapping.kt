package pawfinder.animals.mapping

import pawfinder.animals.model.Animal
import pawfinder.animals.model.Attributes
import pawfinder.animals.model.Breeds
import pawfinder.animals.model.Contact
import pawfinder.animals.model.Href
import pawfinder.animals.model.Links
import pawfinder.animals.model.Photo
import pawfinder.animals.model.PrimaryPhotoCropped
import pawfinder.remote.petfinder.animal.response.model.Animal as PetFinderAnimal
import pawfinder.remote.petfinder.animal.response.model.Attributes as PetFinderAttributes
import pawfinder.remote.petfinder.animal.response.model.Breeds as PetFinderBreeds
import pawfinder.remote.petfinder.animal.response.model.Contact as PetFinderContact
import pawfinder.remote.petfinder.animal.response.model.Links as PetFinderLinks
import pawfinder.remote.petfinder.animal.response.model.Photo as PetFinderPhoto
import pawfinder.remote.petfinder.animal.response.model.PrimaryPhotoCropped as PetFinderPrimaryPhotoCropped

fun Animal.Companion.fromPetFinderAnimal(
    petFinderAnimal: PetFinderAnimal,
): Animal {
    return Animal(
        id = petFinderAnimal.id.toString(),
        age = petFinderAnimal.age,
        attributes = Attributes.fromPetFinderAttributes(petFinderAnimal.attributes),
        breeds = Breeds.fromPetFinderBreeds(petFinderAnimal.breeds),
        contact = Contact.fromPetFinderContacts(petFinderAnimal.contact),
        description = petFinderAnimal.description,
        gender = petFinderAnimal.gender,
        links = Links.fromPetFinderLinks(petFinderAnimal.links),
        name = petFinderAnimal.name,
        organizationAnimalId = petFinderAnimal.organizationAnimalId,
        organizationId = petFinderAnimal.organizationId,
        photos = petFinderAnimal.photos.map(Photo::fromPetFinderPhoto),
        primaryPhotoCropped = PrimaryPhotoCropped.fromPetFinderPrimaryPhotoCropped(petFinderAnimal.primaryPhotoCropped),
        publishedAt = petFinderAnimal.publishedAt,
        size = petFinderAnimal.size,
        species = petFinderAnimal.species,
        status = petFinderAnimal.status,
        statusChangedAt = petFinderAnimal.statusChangedAt,
        type = petFinderAnimal.type,
        url = petFinderAnimal.url,
    )
}

private fun Attributes.Companion.fromPetFinderAttributes(
    petFinderAttributes: PetFinderAttributes,
): Attributes {
    return Attributes(
        declawed = petFinderAttributes.declawed,
        houseTrained = petFinderAttributes.houseTrained,
        shotsCurrent = petFinderAttributes.shotsCurrent,
        spayedNeutered = petFinderAttributes.spayedNeutered,
        specialNeeds = petFinderAttributes.specialNeeds,
    )
}

private fun Breeds.Companion.fromPetFinderBreeds(
    petFinderBreeds: PetFinderBreeds,
): Breeds {
    return Breeds(
        mixed = petFinderBreeds.mixed,
        primary = petFinderBreeds.primary,
        secondary = petFinderBreeds.secondary,
        unknown = petFinderBreeds.unknown,
    )
}

private fun Contact.Companion.fromPetFinderContacts(
    petFinderContact: PetFinderContact,
): Contact {
    return Contact(
        address = petFinderContact.address.address,
        city = petFinderContact.address.city,
        country = petFinderContact.address.country,
        postcode = petFinderContact.address.postcode,
        state = petFinderContact.address.state,
        email = petFinderContact.email,
        phone = petFinderContact.phone,
    )
}

private fun Links.Companion.fromPetFinderLinks(
    petFinderLinks: PetFinderLinks,
): Links {
    return Links(
        organization = Href(petFinderLinks.organization.href),
        self = Href(petFinderLinks.self.href),
        type = Href(petFinderLinks.type.href)
    )
}

private fun PrimaryPhotoCropped.Companion.fromPetFinderPrimaryPhotoCropped(
    petFinderPrimaryPhotoCropped: PetFinderPrimaryPhotoCropped?,
): PrimaryPhotoCropped? {
    if (petFinderPrimaryPhotoCropped == null) return null
    return PrimaryPhotoCropped(
        full = petFinderPrimaryPhotoCropped.full,
        large = petFinderPrimaryPhotoCropped.large,
        medium = petFinderPrimaryPhotoCropped.medium,
        small = petFinderPrimaryPhotoCropped.small,
    )
}

private fun Photo.Companion.fromPetFinderPhoto(
    petFinderPhoto: PetFinderPhoto,
): Photo {
    return Photo(
        full = petFinderPhoto.full,
        large = petFinderPhoto.large,
        medium = petFinderPhoto.medium,
        small = petFinderPhoto.small,
    )
}
