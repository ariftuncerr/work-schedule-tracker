package com.ariftuncer.workscheduletracker.data.repository

import com.ariftuncer.workscheduletracker.data.local.dao.ProjectDao
import com.ariftuncer.workscheduletracker.data.local.entity.ProjectEntity

class ProjectRepository(
    private val projectDao: ProjectDao
){
    suspend fun insertProject(project : ProjectEntity){
        projectDao.insertProject(project)

    }
    suspend fun getUserProjects(userId : String){
        projectDao.getUserProjects(userId)
    }
}