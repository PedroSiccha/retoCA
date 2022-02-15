package com.example.retotecnico.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retotecnico.domains.*
import com.example.retotecnico.data.model.HitsModel
import com.example.retotecnico.data.model.NoticiasModel
import com.example.retotecnico.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class NoticiaViewModel @Inject constructor(
    private val getNoticiasUseCase: getNoticiasUseCase
)  : ViewModel() {

    val noticiaModel = MutableLiveData<HitsModel?>()
    val isLoading = MutableLiveData<Boolean>()

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