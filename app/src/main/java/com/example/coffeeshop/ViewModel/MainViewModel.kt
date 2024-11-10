package com.example.coffeeshop.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeshop.Model.ItemsModel
import com.example.coffeeshop.Repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository= MainRepository()

    fun loadFiltered(id:Int) :LiveData<MutableList<ItemsModel>> {
        return repository.loadfiltered(id)
    }
}