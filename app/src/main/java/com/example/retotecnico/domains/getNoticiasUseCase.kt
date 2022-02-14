package com.example.retotecnico.domains

import com.example.retotecnico.data.NoticiaRepository
import com.example.retotecnico.data.model.HitsModel

class getNoticiasUseCase {

    private val repository = NoticiaRepository()

    suspend operator fun invoke(): HitsModel? = repository.getNoticias()


}