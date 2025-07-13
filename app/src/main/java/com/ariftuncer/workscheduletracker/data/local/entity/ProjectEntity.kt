package com.ariftuncer.workscheduletracker.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "projects",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity:: class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CompanyEntity:: class,
            parentColumns = ["id"],
            childColumns =  ["company_id"],
            onDelete = ForeignKey.CASCADE
        )

    ])
data class ProjectEntity(
    @PrimaryKey
    val id : String,
    //Foreign Keys
    @ColumnInfo(name = "user_id") // User
    val userId : String,
    @ColumnInfo(name = "company_id") // Company
    val companyId : String,

    //project attributes
    @ColumnInfo(name = "project_name")
    val projectName : String,
    @ColumnInfo(name = "user_salary")
    val userSalary : Double,

)