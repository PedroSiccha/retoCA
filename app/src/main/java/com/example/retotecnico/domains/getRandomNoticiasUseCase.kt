package com.example.retotecnico.domains

import com.example.retotecnico.data.NoticiaRepository
import com.example.retotecnico.data.model.HitsModel
import com.example.retotecnico.data.model.HitsProvider
import com.example.retotecnico.data.model.NoticiaProvider
import com.example.retotecnico.data.model.NoticiasModel

class getRandomNoticiasUseCase {
    //private val repository = NoticiaRepository()
    operator fun invoke(): HitsModel?{
        val noticias: List<HitsModel> = HitsProvider.hits
        if (!noticias.isNullOrEmpty()){
            val randmNumero = (noticias.indices).random()
            return noticias[randmNumero]
        }
        return null
    }
}