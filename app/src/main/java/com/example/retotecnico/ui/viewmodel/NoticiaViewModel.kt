package com.example.retotecnico.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retotecnico.domains.*
import com.example.retotecnico.data.model.HitsModel
import com.example.retotecnico.data.model.NoticiasModel
import com.example.retotecnico.util.Resource
import kotlinx.coroutines.launch

class NoticiaViewModel : ViewModel() {

    val noticiaModel = MutableLiveData<HitsModel?>()
    val isLoading = MutableLiveData<Boolean>()

    var getNoticiasUseCase = getNoticiasUseCase()
    var getRandomNoticiasUseCase = getRandomNoticiasUseCase()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getNoticiasUseCase()
            print("PRUEBA: ${result?.hits}")
            noticiaModel.postValue(result)
            isLoading.postValue(false)

        }
    }

    fun randomNoticia(){
        isLoading.postValue(true)
        val noticias = getRandomNoticiasUseCase()

        if(noticias!=null){
            noticiaModel.postValue(noticias)
        }
        isLoading.postValue(false)
    }

}