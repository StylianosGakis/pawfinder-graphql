package pawfinder

import kotlinx.datetime.Clock
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClockProvider {

    @Suppress("unused")
    @Bean
    fun provideClock(): Clock {
        return Clock.System
    }
}
