package com.example.retotecnico.data.network

import com.example.retotecnico.core.RetrofitHelper
import com.example.retotecnico.data.model.HitsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class NoticiaService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getNoticias(): HitsModel {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(NoticiaApiClient::class.java).getNoticias()
            response.body()!!
        }
    }

}