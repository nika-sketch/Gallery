package ge.nlatsabidze.gallery.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityData(
    @Json(name = "current")
    val current: Current?,
    @Json(name = "location")
    val location: Location?
)