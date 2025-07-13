package com.ariftuncer.workscheduletracker.data.repository

import com.ariftuncer.workscheduletracker.data.local.dao.UserDao
import com.ariftuncer.workscheduletracker.data.local.entity.UserEntity

class UserRepository (
    private val userDao: UserDao
){
    suspend fun insertUser(user : UserEntity){
        userDao.insertUser(user)
    }
}