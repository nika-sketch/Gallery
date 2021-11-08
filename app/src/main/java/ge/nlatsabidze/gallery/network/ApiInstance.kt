package ge.nlatsabidze.gallery.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiInstance {

    private const val BASE_URL = "https://api.weatherapi.com/"
    private const val SECOND_BASE_URL = "https://api.openweathermap.org/"

    val API: Api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()))
            .build()
            .create(Api::class.java)
    }

    val SECONDAPI: Api by lazy {
        Retrofit.Builder()
            .baseUrl(SECOND_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()))
            .build()
            .create(Api::class.java)
    }
}