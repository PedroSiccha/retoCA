package com.example.retotecnico.data

import com.example.retotecnico.data.model.HitsModel
import com.example.retotecnico.data.model.NoticiaProvider
import com.example.retotecnico.data.network.NoticiaService
import javax.inject.Inject

class NoticiaRepository @Inject constructor(
    private val api: NoticiaService,
    private val noticiaProvider: NoticiaProvider
) {
    suspend fun getNoticias(): HitsModel {
        val response = api.getNoticias()
        noticiaProvider.noticias = response!!
        return response
    }
}