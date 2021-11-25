package com.clonecodingbm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clonecodingbm.data.local.recentsearch.RecentSearchDao
import com.clonecodingbm.data.local.recentsearch.RecentSearchEntity
import com.clonecodingbm.data.local.login.UserDao
import com.clonecodingbm.data.local.login.UserEntity

@Database(entities = [UserEntity::class, RecentSearchEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun recentSearchDao(): RecentSearchDao
}