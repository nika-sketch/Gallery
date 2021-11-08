package ge.nlatsabidze.gallery.modelPolution

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Main(
    @Json(name = "co")
    val aqi: Int?
)
