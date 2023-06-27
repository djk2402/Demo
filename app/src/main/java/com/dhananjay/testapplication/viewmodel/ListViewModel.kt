package com.dhananjay.testapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhananjay.testapplication.model.ListItem
import com.dhananjay.testapplication.repository.ListItemRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(private val repository: ListItemRepository) : ViewModel() {

    val productsLiveData : LiveData<List<ListItem>>
        get() = repository.listItems

    init {
        viewModelScope.launch {
            //delay(10000)
            repository.getItems()
        }
    }

}