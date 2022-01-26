package pawfinder.remote.petfinder.animal.response.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Animal(
    val age: String,
    val attributes: Attributes,
    val breeds: Breeds,
    val contact: Contact,
    val description: String?,
    val gender: String,
    val id: Long,
    @SerialName("_links")
    val links: Links,
    val name: String,
    @SerialName("organization_animal_id")
    val organizationAnimalId: String?,
    @SerialName("organization_id")
    val organizationId: String,
    val photos: List<Photo>,
    @SerialName("primary_photo_cropped")
    val primaryPhotoCropped: PrimaryPhotoCropped?,
    @SerialName("published_at")
    val publishedAt: String,
    val size: String,
    val species: String,
    val status: String,
    @SerialName("status_changed_at")
    val statusChangedAt: String,
    val type: String,
    val url: String,
)

@Serializable
data class Attributes(
    val declawed: Boolean?,
    @SerialName("house_trained")
    val houseTrained: Boolean,
    @SerialName("shots_current")
    val shotsCurrent: Boolean,
    @SerialName("spayed_neutered")
    val spayedNeutered: Boolean,
    @SerialName("special_needs")
    val specialNeeds: Boolean,
)

@Serializable
data class Breeds(
    val mixed: Boolean,
    val primary: String,
    val secondary: String?,
    val unknown: Boolean,
)

@Serializable
data class Contact(
    val address: Address,
    val email: String?,
    val phone: String?,
) {
    @Serializable
    data class Address(
        @SerialName("address1")
        val address: String?,
        val city: String,
        val country: String,
        val postcode: String?,
        val state: String,
    )
}

@Serializable
data class Links(
    val organization: Organization,
    val self: Self,
    val type: Type,
) {
    @Serializable
    data class Organization(
        val href: String,
    )

    @Serializable
    data class Self(
        val href: String,
    )

    @Serializable
    data class Type(
        val href: String,
    )
}

@Serializable
data class Photo(
    val full: String,
    val large: String,
    val medium: String,
    val small: String,
)

@Serializable
data class PrimaryPhotoCropped(
    val full: String,
    val large: String,
    val medium: String,
    val small: String,
)
