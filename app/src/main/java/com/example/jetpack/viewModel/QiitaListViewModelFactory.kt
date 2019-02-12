package com.example.jetpack.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QiitaListViewModelFactory(): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QiitaListViewModel() as T
    }
}