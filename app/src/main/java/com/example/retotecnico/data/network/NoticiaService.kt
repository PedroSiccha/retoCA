package com.example.retotecnico.data.network

import com.example.retotecnico.core.RetrofitHelper
import com.example.retotecnico.data.model.HitsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class NoticiaService @Inject constructor(private val api: NoticiaApiClient) {

    suspend fun getNoticias(): HitsModel {
        return withContext(Dispatchers.IO){
            val response = api.getNoticias()
            response.body()!!
        }
    }

}