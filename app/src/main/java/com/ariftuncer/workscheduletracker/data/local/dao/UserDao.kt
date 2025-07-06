package com.ariftuncer.workscheduletracker.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.ariftuncer.workscheduletracker.data.local.entity.UserEntity
import io.reactivex.Flowable

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll() : Flowable <List<UserEntity>>

}