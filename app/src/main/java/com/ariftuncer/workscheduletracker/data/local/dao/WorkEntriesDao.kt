package com.ariftuncer.workscheduletracker.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.ariftuncer.workscheduletracker.data.local.entity.WorkEntriesEntity
import io.reactivex.Flowable

@Dao
interface WorkEntriesDao {
    @Query("SELECT * FROM work_entries")
    fun getAll() : Flowable<List<WorkEntriesEntity>>
}