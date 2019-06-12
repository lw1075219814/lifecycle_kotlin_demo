package com.lifecycle.kotlin.demo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 *
 * @Module.Name
 * @author liuwen
 * @Create.Date 2019-06-12 10:59
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019-06-12 10:59
 * @see
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE user_id= :id")
    fun getUserById(id: Long): Flowable<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User): Completable
}