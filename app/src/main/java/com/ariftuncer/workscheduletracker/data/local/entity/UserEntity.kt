package com.ariftuncer.workscheduletracker.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "user")
data class  UserEntity(
    @PrimaryKey
    val id : String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "username")
    val userName : String,
    @ColumnInfo(name = "email")
    val userEmail : String,
    @ColumnInfo(name = "password")
    val userPassword : String,
    @ColumnInfo(name = "created_at")
    val createdAt : Long
)