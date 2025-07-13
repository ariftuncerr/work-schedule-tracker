package com.ariftuncer.workscheduletracker.view.operations.companyAndProjects

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ariftuncer.workscheduletracker.data.local.AppDatabase
import com.ariftuncer.workscheduletracker.data.local.dao.CompanyDao
import com.ariftuncer.workscheduletracker.data.local.dao.ProjectDao
import com.ariftuncer.workscheduletracker.data.local.dao.UserDao
import com.ariftuncer.workscheduletracker.data.local.entity.CompanyEntity
import com.ariftuncer.workscheduletracker.data.local.entity.ProjectEntity
import com.ariftuncer.workscheduletracker.data.repository.CompanyRepository
import com.ariftuncer.workscheduletracker.data.repository.ProjectRepository
import kotlinx.coroutines.launch

class CompanyAndProjectsViewModel(application: Application) : AndroidViewModel(application){
    private val companyRepository : CompanyRepository
    private val projectRepository : ProjectRepository

    private var _projects = MutableLiveData<List<ProjectEntity>>()
    val projects: LiveData<List<ProjectEntity>> get() = _projects

    private var _companies = MutableLiveData<List<CompanyEntity>>()
    val companies: LiveData<List<CompanyEntity>> get() = _companies

    init {
        val companyDao : CompanyDao = AppDatabase.getDatabase(application).companyDao()
        companyRepository = CompanyRepository(companyDao)

        val projectDao : ProjectDao = AppDatabase.getDatabase(application).projectDao()
        projectRepository = ProjectRepository(projectDao)
    }


    fun insertCompany(company : CompanyEntity) = viewModelScope.launch {
        companyRepository.insertCompany(company)
    }
    fun insertProject(project : ProjectEntity) = viewModelScope.launch {
        projectRepository.insertProject(project)
    }
    fun getUserProjects(userId : String) = viewModelScope.launch {
        //liveData<List<ProjectEntity>>
        val result = projectRepository.getUserProjects(userId)
        _projects.value = result as List<ProjectEntity>?
    }
    fun getUserCompany(userId : String) = viewModelScope.launch {

        val result = companyRepository.getUserCompanies(userId)
        _companies.value = result as List<CompanyEntity>?
    }

}