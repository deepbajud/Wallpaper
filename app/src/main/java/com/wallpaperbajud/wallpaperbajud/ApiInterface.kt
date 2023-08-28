package com.wallpaperbajud.wallpaperbajud

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {

    @GET("search")
    fun getphotos(
        @Header("Authorization")auth:String,
        @Query("query")query: String
    ): Call<PhotoModel>

}