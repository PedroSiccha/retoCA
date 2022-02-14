package com.example.retotecnico.data.local

import com.example.retotecnico.util.Constantes
import com.example.retotecnico.util.Resource
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.Success(body)
            }
            return error(response.message(), response)
        } catch (e: Exception) {
            return error(e.message ?: e.toString(), null)
        }
    }

    private fun <T> error(message: String, response: Response<T>?): Resource<T> {
        /*
        Timber.d("error: $message")
        Timber.d("errorCode: ${response?.code()}")
        Timber.d("errorData: ${response?.errorBody()}")
         */

        if (response?.code() == 400 || response?.code() == 401 || response?.code() == 614 || response?.code() == 418) {
            var jsonObject: JSONObject? = null
            try {
                jsonObject = JSONObject(response?.errorBody()!!.string())
                val message = jsonObject.getString("message")

                if(response?.code() == 418){
                    val data: String = jsonObject.getString("data")
                    return Resource.Error(Constantes.LOGOUT_FROM_ALL_DEVICE, data as T)
                }else{
                    return Resource.Error(message)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }

        if(response?.code() == 500){
            return Resource.Error(message)
        }

        return Resource.Error("La red ha fallado. Verifique la conexión a Internet.")
    }

}