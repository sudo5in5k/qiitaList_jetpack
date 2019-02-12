package com.example.jetpack.utils

import com.example.jetpack.viewModel.QiitaListViewModelFactory

object Injector {

    fun provideQiitaListViewModelFactory(): QiitaListViewModelFactory {
        return QiitaListViewModelFactory()
    }
}