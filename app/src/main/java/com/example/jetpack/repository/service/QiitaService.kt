package com.example.jetpack.repository.service

import com.example.jetpack.repository.model.QiitaItem
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface QiitaService {

    companion object {
        const val URL = "https://qiita.com/api/v2/"
    }

    @GET("items")
    fun items(): Deferred<Response<List<QiitaItem>>>
}