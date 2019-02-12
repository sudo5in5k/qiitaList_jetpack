package com.example.jetpack.repository

import com.example.jetpack.repository.service.QiitaService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object QiitaClient {
    fun get(): QiitaService {
        val builder = Retrofit.Builder()
            .client(OkHttpClient())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .baseUrl(QiitaService.URL)
            .build()
        return builder.create(QiitaService::class.java)
    }
}