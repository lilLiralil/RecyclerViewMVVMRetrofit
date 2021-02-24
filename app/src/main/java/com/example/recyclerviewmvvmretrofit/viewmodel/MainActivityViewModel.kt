package com.example.recyclerviewmvvmretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewmvvmretrofit.models.RecyclerList
import com.example.recyclerviewmvvmretrofit.network.RetroInstance
import com.example.recyclerviewmvvmretrofit.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
   lateinit var recyclerListLiveData : MutableLiveData<RecyclerList>

    init {
        recyclerListLiveData = MutableLiveData()

    }
    fun getRecyclerList0bserver() : MutableLiveData<RecyclerList>{
        return recyclerListLiveData
    }
    fun makeApiCall(){
        viewModelScope.launch (Dispatchers.IO){
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)
        }
    }
}