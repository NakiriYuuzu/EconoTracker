package core.data.source.remote

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.POST
import kotlinx.coroutines.flow.Flow

interface AdhdApi {
    companion object {
        const val BASE_URL = "https://yuuzu.net/api/"
    }

    @GET("Levels")
    suspend fun getLevels(): List<LevelsItem>

    @GET("Levels")
    fun getLevelsFlow(): Flow<List<LevelsItem>>

//    @GET("Levels")
//    suspend fun getLevelsResponse(): Response<List<LevelsItem>>

//    @POST("/Levels")
//    suspend fun postLevels(level: LevelsItem): Flow<Levels>
}