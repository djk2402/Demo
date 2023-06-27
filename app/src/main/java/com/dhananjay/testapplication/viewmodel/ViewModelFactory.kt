package com.dhananjay.testapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dhananjay.testapplication.repository.ListItemRepository
import javax.inject.Inject

//freecompilerArgs = ['-Xjvm-default=enable']
class ViewModelFactory @Inject constructor(private val repository: ListItemRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }
}