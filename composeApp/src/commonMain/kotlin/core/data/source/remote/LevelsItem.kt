package core.data.source.remote

import kotlinx.serialization.Serializable

@Serializable
data class LevelsItem(
    val createdAt: String,
    val difficulty: String,
    val id: String,
    val levelNumber: Int,
    val playerId: String,
    val score: Int,
    val time: Int
)