package com.ming.lifecycle_kotlin.mav.presenter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.ming.lifecycle_kotlin.helper.LifecycleHelper
import com.ming.lifecycle_kotlin.listener.LifecycleObserverIml

open class BasePresenter : LifecycleObserverIml {

    companion object{
        const val TAG = "BasePresenter--kotlin"
    }

    private lateinit var lifecycleHelper: LifecycleHelper

    private lateinit var fragmentActivity:FragmentActivity

    private lateinit var fragment: Fragment

    constructor(fragmentActivity: FragmentActivity) {
        bindLifecycleOwner(fragmentActivity)
    }

    private fun bindLifecycleOwner(any: Any) {
        if (any is FragmentActivity) {
            this.fragmentActivity = any
        }

        if (any is Fragment) {
            this.fragment = any
            this.fragmentActivity = fragment.activity!!
        }

        lifecycleHelper = LifecycleHelper.with(any)
            .addLifecycleCallback(this)
    }

    fun getActivity():FragmentActivity = fragmentActivity


    override fun onCreate() {
        Log.e(TAG,"onCreate()")
    }

    override fun onStart() {
        Log.e(TAG,"onStart()")
    }

    override fun onResume() {
        Log.e(TAG,"onResume()")
    }

    override fun onPause() {
        Log.e(TAG,"onPause()")
    }

    override fun onStop() {
        Log.e(TAG,"onStop()")
    }

    override fun onDestroy() {
        Log.e(TAG,"onDestroy()")
        lifecycleHelper.clearAll()
    }
}