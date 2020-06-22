package com.ming.lifecycle_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ming.lifecycle_kotlin.mav.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val loginPresenter:LoginPresenter
        get() {
            return LoginPresenter(this)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_text.setOnClickListener { textOnClick() }
    }

    private fun textOnClick() {
        loginPresenter.login("13678496230","872430")
    }
}