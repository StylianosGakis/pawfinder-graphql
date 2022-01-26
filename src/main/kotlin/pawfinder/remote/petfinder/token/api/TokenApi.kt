package pawfinder.remote.petfinder.token.api

import pawfinder.remote.petfinder.token.response.TokenResponse

interface TokenApi {
    suspend fun getToken(): TokenResponse
}
