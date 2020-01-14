package com.tetra.newyorktimes

import android.annotation.SuppressLint
import android.app.Application

class Session : Application() {
    private val tag = Session::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        mInstance = this

    }


    companion object {
        @SuppressLint("StaticFieldLeak")
        var mInstance: Session? = null

        @Synchronized
        fun getInstance(): Session? {
            return mInstance
        }
    }
}