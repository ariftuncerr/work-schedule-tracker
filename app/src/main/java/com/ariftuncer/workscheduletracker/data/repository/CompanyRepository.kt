package com.ariftuncer.workscheduletracker.data.repository

import com.ariftuncer.workscheduletracker.data.local.dao.CompanyDao
import com.ariftuncer.workscheduletracker.data.local.entity.CompanyEntity

class CompanyRepository (
    private val companyDao: CompanyDao,
) {
    suspend fun insertCompany(company : CompanyEntity){
        companyDao.insertCompany(company)

    }
    suspend fun getUserCompanies(userId : String){
        companyDao.getUserCompanies(userId)
    }
}
