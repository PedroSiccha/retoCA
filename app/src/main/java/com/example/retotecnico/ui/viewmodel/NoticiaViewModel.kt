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

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getNoticiasUseCase()
            print("PRUEBA: ${result?.hits}")
            noticiaModel.postValue(result)
            isLoading.postValue(false)

        }
    }

}