package com.zm.common

import android.app.Application

/**
 * Created by zm on 2019/2/25.
 */
object Common {
    private var application: Application? = null

    fun init(application: Application){
        this.application = application
    }

    fun getApplication(): Application? {
        return this.application
    }
}