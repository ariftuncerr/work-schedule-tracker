package com.ariftuncer.workscheduletracker.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.ariftuncer.workscheduletracker.data.local.entity.ProjectEntity
import io.reactivex.Flowable

@Dao
interface ProjectDao {
    @Query("Select * From projects")
    fun getAll() : Flowable<List<ProjectEntity>>

}