package com.ming.lifecycle_kotlin.helper

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

class LifecycleHelper {

    private lateinit var lifecycleOwner :LifecycleOwner
    private lateinit var lifecycleCallbacks : MutableList<LifecycleObserver>

    constructor(any: Any?) {
        if (any is LifecycleOwner) {
            lifecycleOwner = any
            lifecycleCallbacks = mutableListOf()
        }
    }

    companion object{
        fun with(any: Any?):LifecycleHelper{
            return LifecycleHelper(any)
        }

        fun with(appCompatActivity: AppCompatActivity):LifecycleHelper{
            return LifecycleHelper(appCompatActivity)
        }

        fun with(fragment:Fragment):LifecycleHelper{
            return LifecycleHelper(fragment)
        }
    }


    fun addLifecycleCallback(lifecycleObserver: LifecycleObserver):LifecycleHelper{
        lifecycleCallbacks.add(lifecycleObserver)
        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)
        return this
    }

    private fun removeLifecycleCallback(lifecycleObserver: LifecycleObserver):LifecycleHelper{
        lifecycleCallbacks.remove(lifecycleObserver)
        lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
        return this
    }

    private fun getLifecycleCallback():MutableList<LifecycleObserver>{
        return lifecycleCallbacks
    }

    fun clearAll(){
        getLifecycleCallback().forEach {
            removeLifecycleCallback(it)
        }
        lifecycleCallbacks.clear()
    }
}