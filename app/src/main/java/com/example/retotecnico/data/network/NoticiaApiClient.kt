package com.example.retotecnico.data.network

import com.example.retotecnico.data.Responses.NoticiasResponse
import com.example.retotecnico.data.model.HitsModel
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface NoticiaApiClient {

    @GET("search_by_date?query=mobile")
    suspend fun getNoticias(): Response<HitsModel>

}