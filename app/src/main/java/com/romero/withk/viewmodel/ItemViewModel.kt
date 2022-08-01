package com.romero.withk.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.romero.withk.domain.GetItems
import com.romero.withk.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(): ViewModel() {

    val items = MutableLiveData<List<Item>>()

    var getItems = GetItems()

    fun getAllItems(page: Int, limit: Int) {

        viewModelScope.launch(Dispatchers.IO) {

            val result = getItems(page, limit)

            if(result.isNotEmpty()) {
                items.postValue(result)
            }
        }

    }

}