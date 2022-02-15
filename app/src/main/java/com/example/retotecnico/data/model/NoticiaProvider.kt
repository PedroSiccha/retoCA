package com.example.retotecnico.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoticiaProvider @Inject constructor() {
    var noticias: HitsModel = HitsModel(0, 0, 0, 0, false, false, "", "", 0, listOf())
}