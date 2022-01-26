@file:Suppress("unused")

package pawfinder.remote.petfinder.token.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class TokenRequest private constructor(
    @SerialName("grant_type")
    val grantType: String,
    @SerialName("client_id")
    val clientId: String,
    @SerialName("client_secret")
    val clientSecret: String,
) {
    companion object {
        fun create(
            clientId: String,
            clientSecret: String,
        ): TokenRequest =
            TokenRequest(
                grantType = "client_credentials",
                clientId = clientId,
                clientSecret = clientSecret,
            )
    }
}
