package com.ariftuncer.workscheduletracker.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ariftuncer.workscheduletracker.data.local.AppDatabase
import com.ariftuncer.workscheduletracker.data.local.dao.UserDao
import com.ariftuncer.workscheduletracker.data.local.entity.UserEntity
import com.ariftuncer.workscheduletracker.data.repository.UserRepository
import kotlinx.coroutines.launch

class MainViewModel(application : Application) : AndroidViewModel(application){
    private val repository : UserRepository

    init {
        //main view model ilk oluşturulmasıyla initializee olup userDao nesnesini oluşturur.
        val userDao : UserDao = AppDatabase.getDatabase(application).userDao()
        // view - viewModel - functions - repostiories - dao - model - db
        repository = UserRepository(userDao)


    }
    fun insert(user : UserEntity) = viewModelScope.launch {
        repository.insertUser(user)
    }
}