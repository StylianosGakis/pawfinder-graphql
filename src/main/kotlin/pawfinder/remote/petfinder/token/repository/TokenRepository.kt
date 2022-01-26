package pawfinder.remote.petfinder.token.repository

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import pawfinder.remote.petfinder.token.TokenResponseStore
import pawfinder.remote.petfinder.token.api.TokenApi

@Repository
class TokenRepository(
    private val tokenApi: TokenApi,
    private val tokenResponseStore: TokenResponseStore,
    private val logger: Logger = LoggerFactory.getLogger(TokenRepository::class.java),
) {

    suspend fun getBearerToken(): String {
        val activeToken = tokenResponseStore.getActiveTokenOrNull()
        if (activeToken != null) {
            logger.info("Using cached token")
            return activeToken.accessToken
        }
        logger.info("Fetching new token")
        val refreshedTokenResponse = tokenApi.getToken()
        tokenResponseStore.updateToken(refreshedTokenResponse)
        return refreshedTokenResponse.accessToken
    }
}
