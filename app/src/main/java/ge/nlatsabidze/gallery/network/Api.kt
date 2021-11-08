package ge.nlatsabidze.gallery.network

import ge.nlatsabidze.gallery.daily.Day
import ge.nlatsabidze.gallery.model.CityData
import ge.nlatsabidze.gallery.modelPolution.AirPolution
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/v1/current.json?key=85b31947308b4fd5ac4111446210611&q=Tbilisi&aqi=no")
    suspend fun getItems(): Response<CityData>

    @GET("/data/2.5/air_pollution?lat=42&lon=43&appid=6a5c61db40d3d90f0f823f8c86307dc0")
    suspend fun getAirPolutionItems(): Response<AirPolution>

    @GET("/data/2.5/onecall?lat=43&lon=42&exclude=current,minutely,hourly,alerts&appid=6a5c61db40d3d90f0f823f8c86307dc0&units=metric")
    suspend fun getDaily(): Response<Day>
}
