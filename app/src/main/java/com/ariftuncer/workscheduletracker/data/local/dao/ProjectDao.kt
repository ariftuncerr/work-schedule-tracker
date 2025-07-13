package com.ariftuncer.workscheduletracker.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ariftuncer.workscheduletracker.data.local.entity.ProjectEntity
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDao {
    @Query("Select * From projects")
    fun getAll() : Flowable<List<ProjectEntity>>

    @Insert
    suspend fun insertProject(project: ProjectEntity)

    @Query("SELECT * FROM projects WHERE user_id = :userId")
    fun getUserProjects(userId : String) : LiveData<List<ProjectEntity>>

}