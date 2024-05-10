package core.data.source.remote

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.FlowConverterFactory
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorfitFactory {
    fun build(): Ktorfit {
        return ktorfit {
            baseUrl(AdhdApi.BASE_URL)
            httpClient(HttpClient {
                install(ContentNegotiation) {
                    json(
                        json = Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                        }
                    )
                }
            })
            converterFactories(
                FlowConverterFactory()
            )
        }
    }
}