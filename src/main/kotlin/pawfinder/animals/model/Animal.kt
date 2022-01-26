package pawfinder.animals.model

import com.expediagroup.graphql.generator.annotations.GraphQLDescription

data class Animal(
    @GraphQLDescription("The ID of the animal")
    val id: String,
    val age: String,
    val attributes: Attributes,
    val breeds: Breeds,
    val contact: Contact,
    val description: String?,
    val gender: String,
    val links: Links,
    val name: String,
    val organizationAnimalId: String?,
    val organizationId: String,
    val photos: List<Photo>,
    val primaryPhotoCropped: PrimaryPhotoCropped?,
    val publishedAt: String,
    val size: String,
    val species: String,
    val status: String,
    val statusChangedAt: String,
    val type: String,
    val url: String,
) {
    companion object
}

data class Attributes(
    val declawed: Boolean?,
    val houseTrained: Boolean,
    val shotsCurrent: Boolean,
    val spayedNeutered: Boolean,
    val specialNeeds: Boolean,
) {
    companion object
}

data class Breeds(
    val mixed: Boolean,
    val primary: String,
    val secondary: String?,
    val unknown: Boolean,
) {
    companion object
}

data class Contact(
    val address: String?,
    val city: String,
    val country: String,
    val postcode: String?,
    val state: String,
    val email: String?,
    val phone: String?,
) {
    companion object
}

data class Links(
    val organization: Href,
    val self: Href,
    val type: Href,
) {
    companion object
}

data class Photo(
    val full: String,
    val large: String,
    val medium: String,
    val small: String,
) {
    companion object
}

data class PrimaryPhotoCropped(
    val full: String,
    val large: String,
    val medium: String,
    val small: String,
) {
    companion object
}

@Suppress("unused")
@JvmInline
value class Href(val href: String)
