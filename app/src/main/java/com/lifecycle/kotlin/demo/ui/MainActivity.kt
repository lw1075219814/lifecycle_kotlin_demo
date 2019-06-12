package com.lifecycle.kotlin.demo.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.lifecycle.kotlin.demo.Injection
import com.lifecycle.kotlin.demo.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    private val disposable = CompositeDisposable()

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var factory = Injection.providerUserViewModelFactory(this)
        userViewModel = ViewModelProviders.of(this, factory).get(UserViewModel::class.java)

        btnOk.setOnClickListener { updateUserName() }
    }

    override fun onStart() {
        super.onStart()
        refresh()
    }

    override fun onStop() {
        super.onStop()
        if (disposable != null && !disposable.isDisposed) {
            disposable.clear()
        }
    }

    fun refresh() {
        disposable.add(
            userViewModel.getUserName()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ tvResult.text = it },
                    { error -> Log.d(TAG, error.message) })
        )
    }

    fun updateUserName() {
        val text = editText.text.toString().trim()
        btnOk.isEnabled = false
        disposable.add(
            userViewModel.insertUser(text)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ btnOk.isEnabled = true },
                    { error -> Log.d(TAG, error.message) })
        )
    }
}
