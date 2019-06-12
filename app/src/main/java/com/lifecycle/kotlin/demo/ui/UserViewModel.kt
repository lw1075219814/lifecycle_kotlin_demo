package com.lifecycle.kotlin.demo.ui

import androidx.lifecycle.ViewModel
import com.lifecycle.kotlin.demo.db.User
import com.lifecycle.kotlin.demo.db.UserDao
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 *
 * @Module.Name
 * @author liuwen
 * @Create.Date 2019-06-12 11:19
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019-06-12 11:19
 * @see
 */
class UserViewModel(private val dataSource: UserDao) : ViewModel() {

    companion object {
        const val USER_ID = 1L
    }

    fun getUserName(): Flowable<String> = dataSource.getUserById(USER_ID).map { user -> user.userName }

    fun insertUser(userName: String): Completable = dataSource.insertUser(User(1L, userName))
}