package com.ariftuncer.workscheduletracker.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "work_entries",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity :: class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CompanyEntity :: class,
            parentColumns = ["id"],
            childColumns = ["company_id"],
            onDelete = ForeignKey.CASCADE

        ),
        ForeignKey(
            entity = ProjectEntity :: class,
            parentColumns = ["id"],
            childColumns = ["project_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class WorkEntriesEntity (

    @PrimaryKey
    val id : String,

    //foreign keys
    @ColumnInfo(name = "user_id")
    val userId : String,
    @ColumnInfo(name = "company_id")
    val companyId : String,
    @ColumnInfo(name = "project_id")
    val projectId : String,

    @ColumnInfo(name = "work_date")
    val workDate : String,

    @ColumnInfo(name = "work_type")
    val workType : String

)