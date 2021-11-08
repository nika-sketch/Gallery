package ge.nlatsabidze.gallery.modelPolution


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AirPolution(
    @Json(name = "coord")
    val coord: Coord?,
    @Json(name = "list")
    val list: List<AirPolutionResponse>?
)