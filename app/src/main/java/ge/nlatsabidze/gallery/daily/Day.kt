package ge.nlatsabidze.gallery.daily


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Day(
    @Json(name = "daily")
    val daily: List<Daily>?,
    @Json(name = "lat")
    val lat: Int?,
    @Json(name = "lon")
    val lon: Int?,
    @Json(name = "timezone")
    val timezone: String?,
    @Json(name = "timezone_offset")
    val timezoneOffset: Int?
)