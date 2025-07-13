package com.ariftuncer.workscheduletracker.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ariftuncer.workscheduletracker.data.local.dao.CompanyDao
import com.ariftuncer.workscheduletracker.data.local.dao.ProjectDao
import com.ariftuncer.workscheduletracker.data.local.dao.UserDao
import com.ariftuncer.workscheduletracker.data.local.dao.WorkEntriesDao
import com.ariftuncer.workscheduletracker.data.local.entity.CompanyEntity
import com.ariftuncer.workscheduletracker.data.local.entity.ProjectEntity
import com.ariftuncer.workscheduletracker.data.local.entity.UserEntity
import com.ariftuncer.workscheduletracker.data.local.entity.WorkEntriesEntity

@Database(entities = [UserEntity:: class,CompanyEntity::class, ProjectEntity :: class, WorkEntriesEntity :: class], version = 1 )
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun companyDao() : CompanyDao
    abstract fun projectDao() : ProjectDao
    abstract fun workEntriesDao() : WorkEntriesDao

    companion object{
        @Volatile //anatasyon sayensinde tüm threadler ile iletişim kurulur
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase :: class.java,
                    "work_schedule_db"
                ).build() // veritabanı örneği oluşturulur ve INSTANCE a eşitlenir getDatabase üzerinden bu instance döner

                INSTANCE = instance
                return instance

            }

        }
    }
}