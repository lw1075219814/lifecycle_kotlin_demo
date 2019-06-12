package com.lifecycle.kotlin.demo

import android.content.Context
import com.lifecycle.kotlin.demo.db.UserDao
import com.lifecycle.kotlin.demo.db.UserDatabase
import com.lifecycle.kotlin.demo.ui.UserViewModelFactory

/**
 *
 * @Module.Name
 * @author liuwen
 * @Create.Date 2019-06-12 14:11
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019-06-12 14:11
 * @see
 */
object Injection {
    fun providerUserDataSource(context: Context): UserDao = UserDatabase.getInstance(context).userDao()

    fun providerUserViewModelFactory(context: Context): UserViewModelFactory = UserViewModelFactory(
        providerUserDataSource(context)
    )
}