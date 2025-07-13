package com.ariftuncer.workscheduletracker.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ariftuncer.workscheduletracker.data.local.entity.CompanyEntity
import com.ariftuncer.workscheduletracker.data.local.entity.ProjectEntity
import io.reactivex.Flowable

@Dao
interface CompanyDao {
    @Query("SELECT * FROM company")
    fun getAll() : Flowable<List<CompanyEntity>>

    @Query("SELECT * FROM company WHERE user_id = :userId")
    fun getUserCompanies(userId : String) : LiveData<List<CompanyEntity>>

    @Insert
    suspend fun insertCompany(company : CompanyEntity)

}