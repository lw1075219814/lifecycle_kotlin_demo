package com.lifecycle.kotlin.demo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lifecycle.kotlin.demo.db.UserDao
import java.lang.IllegalArgumentException

/**
 *
 * @Module.Name
 * @author liuwen
 * @Create.Date 2019-06-12 14:12
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019-06-12 14:12
 * @see
 */
class UserViewModelFactory(private val dataSource: UserDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(dataSource) as T
        }
        throw IllegalArgumentException("UnKnown ViewModel Class")
    }

}