package com.lifecycle.kotlin.demo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 *
 * @Module.Name
 * @author liuwen
 * @Create.Date 2019-06-12 10:56
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019-06-12 10:56
 * @see
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase() {

    companion object {

        @Volatile private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase =
            INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java, "User.db"
            ).build()
    }

    abstract fun userDao(): UserDao
}