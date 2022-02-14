package com.example.retotecnico.data

import com.example.retotecnico.data.model.HitsModel
import com.example.retotecnico.data.model.NoticiaProvider
import com.example.retotecnico.data.network.NoticiaService

class NoticiaRepository {

    private val api = NoticiaService()

    suspend fun getNoticias(): HitsModel {
        val response = api.getNoticias()
        NoticiaProvider.noticias = response!!
        return response
    }

}