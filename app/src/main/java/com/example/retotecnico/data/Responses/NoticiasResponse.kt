package com.example.retotecnico.data.Responses

import com.example.retotecnico.data.model.HitsModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NoticiasResponse(

    @SerializedName("hits")
    @Expose
    val hits: HitsModel,

    @SerializedName("nbHits")
    @Expose
    val nbHits: Int,

    @SerializedName("page")
    @Expose
    val page: Int?,

    @SerializedName("nbPages")
    @Expose
    val nbPages: Int,

    @SerializedName("hitsPerPage")
    @Expose
    val hitsPerPage: Int,

    @SerializedName("exhaustiveNbHits")
    @Expose
    val exhaustiveNbHits: Boolean,

    @SerializedName("exhaustiveTypo")
    @Expose
    val exhaustiveTypo: Boolean,

    @SerializedName("query")
    @Expose
    val query: String,

    @SerializedName("params")
    @Expose
    val params: String,

    @SerializedName("processingTimeMS")
    @Expose
    val processingTimeMS: Int

)
