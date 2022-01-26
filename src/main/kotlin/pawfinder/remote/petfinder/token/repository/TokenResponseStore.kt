package pawfinder.remote.petfinder.token

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import org.springframework.stereotype.Service
import pawfinder.remote.petfinder.token.response.TokenResponse
import kotlin.time.Duration.Companion.seconds

interface TokenResponseStore {
    fun getActiveTokenOrNull(): TokenResponse?
    fun updateToken(tokenResponse: TokenResponse)
}

@Service
class TokenResponseStoreImpl(
    private val clock: Clock,
) : TokenResponseStore {
    private var tokenWithExpiration: TokenWithExpiration? = null

    override fun getActiveTokenOrNull(): TokenResponse? {
        val currentToken = tokenWithExpiration ?: return null
        if (currentToken.isExpired(clock.now())) return null
        return currentToken.tokenResponse
    }

    override fun updateToken(tokenResponse: TokenResponse) {
        tokenWithExpiration = TokenWithExpiration.fromTokenResponse(clock.now(), tokenResponse)
    }
}

data class TokenWithExpiration(
    val tokenResponse: TokenResponse,
    val expirationTime: Instant,
) {
    fun isExpired(now: Instant): Boolean {
        return now > expirationTime
    }

    companion object {
        fun fromTokenResponse(now: Instant, tokenResponse: TokenResponse): TokenWithExpiration {
            val expirationTime = now.plus(tokenResponse.expiresIn.seconds)
            return TokenWithExpiration(
                tokenResponse,
                expirationTime
            )
        }
    }
}
