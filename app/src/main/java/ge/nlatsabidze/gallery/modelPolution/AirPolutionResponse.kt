package ge.nlatsabidze.gallery.modelPolution

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ge.nlatsabidze.gallery.modelPolution.Components

@JsonClass(generateAdapter = true)
data class AirPolutionResponse(
    @Json(name = "components")
    val components: Components?
)