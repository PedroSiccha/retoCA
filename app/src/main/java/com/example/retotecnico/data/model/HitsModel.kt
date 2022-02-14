package com.example.retotecnico.data.model

import com.google.gson.annotations.SerializedName

data class HitsModel(

    @SerializedName("nbHits")
    val nbHits: Int,

    @SerializedName("page")
    val page: Int?,

    @SerializedName("nbPages")
    val nbPages: Int,

    @SerializedName("hitsPerPage")
    val hitsPerPage: Int,

    @SerializedName("exhaustiveNbHits")
    val exhaustiveNbHits: Boolean,

    @SerializedName("exhaustiveTypo")
    val exhaustiveTypo: Boolean,

    @SerializedName("query")
    val query: String,

    @SerializedName("params")
    val params: String,

    @SerializedName("processingTimeMS")
    val processingTimeMS: Int,

    @SerializedName("hits")
    val hits: List<NoticiasModel>

)
