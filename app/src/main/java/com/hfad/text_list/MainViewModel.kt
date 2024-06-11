package com.hfad.text_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(private val repository: DataRepository) : ViewModel() {

    val dataItems = MutableLiveData<List<DataItem>>()

    init {
        initializeUniqueItems()
    }
    fun initializeUniqueItems() {
        viewModelScope.launch(Dispatchers.IO) {
            // Create a set to ensure uniqueness
            val uniqueItems = mutableSetOf<String>()
            val items = mutableListOf<DataItem>()

            // Generate 30 unique items
            var count = 1
            while (uniqueItems.size < 30) {
                val text = "Random text $count"
                if (uniqueItems.add(text)) {
                    items.add(DataItem(text = text))
                }
                count++
            }
            repository.insertDataItems(items)

            // Insert items into the repository and update LiveData
            val allItems = repository.getAllDataItems()
            withContext(Dispatchers.Main) {
                dataItems.value = allItems
            }
        }
    }
}


