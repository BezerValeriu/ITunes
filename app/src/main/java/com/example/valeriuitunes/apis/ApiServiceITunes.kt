package com.example.valeriuitunes.apis

import com.example.valeriuitunes.model.ITunesResponse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServiceITunes {

    @GET("search?term=classic&amp;media=music&entity=song&limit=50")
    fun getClassicSongs(
    ): retrofit2.Call<ITunesResponse>

    @GET("search?term=rock&amp;media=music&entity=song&limit=50")
    fun getRockSongs(
    ): retrofit2.Call<ITunesResponse>

    @GET("search?term=pop&amp;media=music&entity=song&limit=50")
    fun getPopSongs(
    ): retrofit2.Call<ITunesResponse>

    companion object{
        private const val BASE_URL = "https://itunes.apple.com/"
        var instance: Retrofit? = null

        fun createRetrofit(): Retrofit{
            if(instance == null){
                instance = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return  instance!!
        }
    }

}