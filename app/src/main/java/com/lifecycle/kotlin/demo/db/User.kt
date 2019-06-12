package com.lifecycle.kotlin.demo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @Module.Name
 * @author liuwen
 * @Create.Date 2019-06-12 10:51
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019-06-12 10:51
 * @see
 */
@Entity(tableName = "user")
data class User(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val userId: Long = 1L,
    @ColumnInfo(name = "user_name")
    val userName: String
)