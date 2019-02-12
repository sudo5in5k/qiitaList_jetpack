package com.example.jetpack.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack.repository.QiitaClient
import com.example.jetpack.repository.model.QiitaItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class QiitaListViewModel : ViewModel() {

    private val job = Job()
    private val scope = CoroutineScope(Main + job)

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    fun getList(): MutableLiveData<List<QiitaItem>> {
        val data = MutableLiveData<List<QiitaItem>>()
        scope.launch {
            val request = QiitaClient.get().items()
            val response = request.await()
            if (response.isSuccessful) {
                data.postValue(response.body())
            } else {
                Log.d("ushi_debig", response.errorBody().toString())
            }
        }
        return data
    }


}