package com.example.android.omdb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {
    @GET(".")
    fun searchMovie(@Query("apikey") apikey: String, @Query("s") serchQuery: String): Call<SearchResponse>
}
// http://www.omdbapi.com/?apikey=d203cc06&s=tit