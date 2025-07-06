package com.ariftuncer.workscheduletracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ariftuncer.workscheduletracker.data.local.dao.CompanyDao
import com.ariftuncer.workscheduletracker.data.local.dao.UserDao
import com.ariftuncer.workscheduletracker.data.local.entity.CompanyEntity
import com.ariftuncer.workscheduletracker.data.local.entity.UserEntity

@Database(entities = [UserEntity:: class,CompanyEntity::class], version = 1 )
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun companyDao() : CompanyDao

}