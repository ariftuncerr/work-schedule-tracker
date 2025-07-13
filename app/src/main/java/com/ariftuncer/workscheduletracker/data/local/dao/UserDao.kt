package com.ariftuncer.workscheduletracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ariftuncer.workscheduletracker.data.local.entity.UserEntity
import io.reactivex.Flowable

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll() : Flowable <List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE) // kullanıcı var ise üzerine yazar upadate eder
    suspend fun insertUser(user : UserEntity) // arka plan işlemi -> suspend coroutine üzerinden çağırlacaksa zorunlu

}