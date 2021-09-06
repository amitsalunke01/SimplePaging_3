package com.amitsalunke.simple_paging_3.network


import com.amitsalunke.simple_paging_3.data.RickAndMortyList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    //sending page no as query parameter
    @GET("character")
    suspend fun getDataFromAPI(@Query("page") query: Int): RickAndMortyList
}