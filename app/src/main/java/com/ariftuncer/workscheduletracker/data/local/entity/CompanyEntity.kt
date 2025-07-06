package com.ariftuncer.workscheduletracker.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.util.getColumnIndex
import java.util.UUID

@Entity(tableName = "company",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"], // user : id -> company : user_id
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CompanyEntity(
    @PrimaryKey
    val id : String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "user_id")
    val userId : String, //foreign key -> users
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "owner_name")
    val owner : String?

)
