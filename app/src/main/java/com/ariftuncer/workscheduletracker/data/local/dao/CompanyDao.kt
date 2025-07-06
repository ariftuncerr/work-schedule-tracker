package com.ariftuncer.workscheduletracker.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.ariftuncer.workscheduletracker.data.local.entity.CompanyEntity
import io.reactivex.Flowable

@Dao
interface CompanyDao {
    @Query("SELECT * FROM company")
    fun getAll() : Flowable<List<CompanyEntity>>

}