package com.yrtelf.amicia.api

import com.yrtelf.amicia.data.character.CharactersResponse
import com.yrtelf.amicia.data.comic.ComicsResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    companion object {
        private const val BASE_URL = "http://gateway.marvel.com/"
        const val API_KEY = "2a1db7136ccfecd3327d3e90dd9ca419"
        const val TS = "1633254291"
        const val HASH = "363cdf38c8e83e7666d1a691be677076"

        fun create(): RetrofitService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder().baseUrl(BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService::class.java)
        }
    }

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int
    ): CharactersResponse

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int
    ): ComicsResponse
}
