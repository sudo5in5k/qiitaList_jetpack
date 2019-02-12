package com.example.jetpack.repository.model

import java.io.Serializable

data class QiitaItem(
    val id: String,
    val title: String,
    val body: String
) : Serializable